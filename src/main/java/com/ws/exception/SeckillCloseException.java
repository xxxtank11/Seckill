package com.ws.exception;

/**
 * 秒杀关闭异常
 * Created by Administrator on 2017/5/31.
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
