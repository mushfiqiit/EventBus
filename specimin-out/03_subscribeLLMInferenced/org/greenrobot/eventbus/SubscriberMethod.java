package org.greenrobot.eventbus;

import javax.annotation.Nonnull;

public class SubscriberMethod {

    @Nonnull
    final Class<?> eventType;

    final int priority = 0;

    final boolean sticky = false;
}
