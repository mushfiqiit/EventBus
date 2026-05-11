package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public final class SubscriberExceptionEvent {

    public final @Nullable Throwable throwable;

    public final @Nullable Object causingEvent;

    public final Object causingSubscriber;

    public SubscriberExceptionEvent(EventBus eventBus, @Nullable Throwable throwable, @Nullable Object causingEvent, Object causingSubscriber) {
        this.throwable = throwable;
        this.causingEvent = causingEvent;
        this.causingSubscriber = causingSubscriber;
    }
}
