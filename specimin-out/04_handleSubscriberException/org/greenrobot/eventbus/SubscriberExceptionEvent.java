package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public final class SubscriberExceptionEvent {

    @Nullable
    public final Throwable throwable;

    @Nullable
    public final Object causingEvent;

    public final Object causingSubscriber;

    public SubscriberExceptionEvent(EventBus eventBus, @Nullable Throwable throwable, @Nullable Object causingEvent, Object causingSubscriber) {
        throw new java.lang.Error();
    }
}
