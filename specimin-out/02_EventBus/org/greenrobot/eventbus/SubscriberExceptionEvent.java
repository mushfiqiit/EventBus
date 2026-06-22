package org.greenrobot.eventbus;

public final class SubscriberExceptionEvent {

    public final Throwable throwable;

    public final Object causingEvent;

    public final Object causingSubscriber;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable throwable, Object causingEvent, Object causingSubscriber) {
        throw new java.lang.Error();
    }
}
