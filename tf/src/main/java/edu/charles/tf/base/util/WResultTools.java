package edu.charles.tf.base.util;

import edu.charles.tf.vo.ErrCodeConstants;
import edu.charles.tf.vo.WResult;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WResultTools {
    public static WResult getWResult(boolean result, Object data, String msg) {
        if (result)
            return getWResult(result, data, msg, ErrCodeConstants.SUCCESS);
        else
            return getWResult(result, data, msg, ErrCodeConstants.SERVICE_ERROR);
    }

    public static WResult getWResult(boolean result, Object data, String msg, int errCode) {
        WResult wResult = new WResult();
        wResult.setData(data);
        wResult.setErrorMsg(msg);
        wResult.setSuccess(result);
        wResult.setErrorCode(errCode);
        return wResult;
    }

    public static WResult getWResult(boolean result, String msg, int errCode) {
        return getWResult(result, null, msg, errCode);
    }
}
