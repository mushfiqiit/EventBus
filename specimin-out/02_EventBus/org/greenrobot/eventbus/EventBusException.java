package org.greenrobot.eventbus;

public class EventBusException extends RuntimeException {

    public EventBusException(String detailMessage) {
        super(detailMessage);
    }

    public EventBusException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
