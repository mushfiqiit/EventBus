package org.greenrobot.eventbus;

import javax.annotation.Nonnull;

public class SubscriberMethod {

    final @Nonnull Class<?> eventType;

    final int priority = 0;

    final boolean sticky = false;
}
