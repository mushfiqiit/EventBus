package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

public class SubscriberMethod {

    @Nonnull
    final Class<?> eventType;

    @Nonnull
    final int priority = 0;

    @Nonnull
    final boolean sticky = false;
}
