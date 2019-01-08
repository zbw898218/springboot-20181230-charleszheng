package edu.charles.tf.vo;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WResult<T> {
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 返回结果
     */
    private boolean success;

    private T data;
    private int errorCode;

    public WResult() {
    }

    public WResult(T data) {
        this.data = data;
    }

    public WResult(boolean success) {
        this.success = success;
    }

    public WResult(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public WResult(String errorMsg, boolean result) {
        this.errorMsg = errorMsg;
        this.success = result;
    }

    public WResult(boolean result, T data) {
        this.success = result;
        this.data = data;
    }

    public WResult(String errorMsg, boolean success, T data, int errorCode) {
        this.errorMsg = errorMsg;
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
    }

    public WResult(String errorMsg, boolean success, T data) {
        this.errorMsg = errorMsg;
        this.success = success;
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WResult{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
