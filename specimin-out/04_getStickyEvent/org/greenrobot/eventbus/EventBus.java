package org.greenrobot.eventbus;

import java.util.Map;

public class EventBus {

    private final Map<Class<?>, Object> stickyEvents;

    public <T> T getStickyEvent(Class<T> eventType) {
        synchronized (stickyEvents) {
            return eventType.cast(stickyEvents.get(eventType));
        }
    }
}
