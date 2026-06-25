package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public class EventBus {

    private final Map<Class<?>, Object> stickyEvents;

    public EventBus() {
        stickyEvents = new ConcurrentHashMap<>();
    }

    @Nullable
    public <T> T getStickyEvent(@Nonnull Class<T> eventType) {
        synchronized (stickyEvents) {
            return eventType.cast(stickyEvents.get(eventType));
        }
    }
}
