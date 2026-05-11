package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public class EventBusException extends RuntimeException {

    public EventBusException(String detailMessage, @Nullable Throwable throwable) {
        throw new java.lang.Error();
    }
}
