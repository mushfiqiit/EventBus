package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public final class SubscriberExceptionEvent {

    @Nullable
    public final Throwable throwable = null;

    @Nullable
    public final Object causingEvent = null;

    public final Object causingSubscriber = null;

    public SubscriberExceptionEvent(EventBus eventBus, @Nullable Throwable throwable, @Nullable Object causingEvent, Object causingSubscriber) {
        throw new java.lang.Error();
    }
}
