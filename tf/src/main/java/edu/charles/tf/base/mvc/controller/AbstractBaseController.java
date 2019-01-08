package edu.charles.tf.base.mvc.controller;

import com.alibaba.fastjson.JSON;
import edu.charles.tf.base.ValueEnum;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.vo.ErrCodeConstants;
import edu.charles.tf.vo.WResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AbstractBaseController<E extends Enum<E>> {
    protected final Log log = LogFactory.getLog(getClass());

    protected Map<String, Object> result(E e, Exception... exception) {
        HashMap<String, Object> result = new HashMap<>();
        ValueEnum valueEnum;
        if (e instanceof ValueEnum) {
            valueEnum = (ValueEnum) e;
            result.put("code", e.name());
            if (null != exception && exception.length > 0) {
                result.put("msg", String.format(valueEnum.getValue().toString(), exception[0].getMessage()));
            } else {
                result.put("msg", String.format(valueEnum.getValue().toString()));
            }
        } else {
            result.put("code", "400");
            result.put("msg", "unknown exception.");
        }
        //
        return result;
    }

    protected Customer getCurrentCustomer() throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer c = null;
        if (principal instanceof Customer) {
            c = (Customer) principal;
        } else
            throw new Exception("bad principal:" + principal.getClass());
        return c;
    }

    @ExceptionHandler
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        log.error("request error", exception);
        //解决getWriter() has already been called for this response
        response.reset();
        //
        WResult result = new WResult();
        result.setSuccess(false);
        result.setErrorCode(ErrCodeConstants.SERVICE_ERROR);
        result.setErrorMsg(exception.getMessage());
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(result));
            response.getWriter().flush();
        } catch (Exception e) {
            log.error("write response error", e);
        }
        return null;
    }
}
