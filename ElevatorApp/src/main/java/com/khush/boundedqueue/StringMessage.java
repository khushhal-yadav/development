package com.khush.boundedqueue;

/**
 * Created by khush on 14/03/2017.
 */
public class StringMessage implements Message<String> {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;

    }
}
