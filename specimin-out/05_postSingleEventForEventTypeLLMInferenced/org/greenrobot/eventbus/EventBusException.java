package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

public class EventBusException extends RuntimeException {

    public EventBusException(@Nonnull String detailMessage) {
        super(detailMessage);
    }
}
