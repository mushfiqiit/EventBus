package org.greenrobot.eventbus;

public final class NoSubscriberEvent {

    public NoSubscriberEvent(EventBus eventBus, Object originalEvent) {
        throw new java.lang.Error();
    }
}
