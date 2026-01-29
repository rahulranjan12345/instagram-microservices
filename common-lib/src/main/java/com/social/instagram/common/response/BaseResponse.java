
package com.social.instagram.common.response;

public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public BaseResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse(true, "SUCCESS", data);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse(false, message, null);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
