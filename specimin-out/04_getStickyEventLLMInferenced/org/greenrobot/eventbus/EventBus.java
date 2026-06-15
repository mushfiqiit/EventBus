package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import java.util.Map;

public class EventBus {

    private final @Nullable Map<Class<?>, Object> stickyEvents;

    public <T> @Nullable T getStickyEvent(@Nonnull Class<T> eventType) {
        synchronized (stickyEvents) {
            return eventType.cast(stickyEvents.get(eventType));
        }
    }
}
