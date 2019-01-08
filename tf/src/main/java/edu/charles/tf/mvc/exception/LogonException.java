package edu.charles.tf.mvc.exception;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LogonException extends Exception{
    public LogonException() {
        super();
    }

    public LogonException(String message) {
        super(message);
    }

    public LogonException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogonException(Throwable cause) {
        super(cause);
    }

    protected LogonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
