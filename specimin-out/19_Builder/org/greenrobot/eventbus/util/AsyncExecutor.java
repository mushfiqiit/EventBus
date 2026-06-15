package org.greenrobot.eventbus.util;

import org.greenrobot.eventbus.EventBus;
import java.util.concurrent.Executor;

public class AsyncExecutor {

    public static class Builder {

        private Executor threadPool;

        private Class<?> failureEventType;

        private EventBus eventBus;

        private Builder() {
        }
    }
}
