package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import javax.annotation.Nullable;

public final class SubscriberExceptionEvent {

    @Nullable
    public final Throwable throwable;

    @Nullable
    public final Object causingEvent;

    @Nonnull
    public final Object causingSubscriber;

    public SubscriberExceptionEvent(@Nonnull EventBus eventBus, @Nullable Throwable throwable, @Nullable Object causingEvent, @Nonnull Object causingSubscriber) {
        throw new java.lang.Error();
    }
}
