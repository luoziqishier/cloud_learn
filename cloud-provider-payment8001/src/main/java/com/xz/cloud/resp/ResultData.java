package com.xz.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author xz
 * @CreateDate 2024/8/19 10:25
 * <p>
 * description:
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {
    private String code;
    private String msg;
    private T data;
    private Long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> result = new ResultData<T>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMsg(ReturnCodeEnum.RC200.getMsg());
        result.setData(data);
        return result;
    }
    public static <T> ResultData<T> fail(String code, String msg) {
        ResultData<T> result = new ResultData<T>();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
