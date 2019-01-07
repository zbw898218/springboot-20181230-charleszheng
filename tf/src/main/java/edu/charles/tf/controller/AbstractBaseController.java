package edu.charles.tf.controller;

import edu.charles.tf.base.ValueEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
}
