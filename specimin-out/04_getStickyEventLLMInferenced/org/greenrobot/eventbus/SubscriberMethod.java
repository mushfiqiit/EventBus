package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

public class SubscriberMethod {

    final Class<?> eventType;

    final int priority = 0;

    final boolean sticky = false;

    public SubscriberMethod(@Nonnull Class<?> eventType) {
        this.eventType = eventType;
    }
}
