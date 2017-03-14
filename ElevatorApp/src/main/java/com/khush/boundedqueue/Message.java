package com.khush.boundedqueue;

/**
 * Created by khush on 14/03/2017.
 */
public interface Message<T> {

    T getMessage();
    void setMessage(T message);
}
