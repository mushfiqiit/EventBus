package org.greenrobot.eventbus.util;

import javax.annotation.Nullable;
import java.util.concurrent.Executor;

public class AsyncExecutor {

    public static class Builder {

        private @Nullable Executor threadPool;

        private @Nullable Class<?> failureEventType;

        private @Nullable EventBus eventBus;

        private Builder() {
        }

        public Builder threadPool(@Nullable Executor threadPool) {
            this.threadPool = threadPool;
            return this;
        }

        public Builder failureEventType(@Nullable Class<?> failureEventType) {
            this.failureEventType = failureEventType;
            return this;
        }

        public Builder eventBus(@Nullable EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public AsyncExecutor buildForScope(Object executionContext) {
            if (eventBus == null) {
                eventBus = EventBus.getDefault();
            }
            if (threadPool == null) {
                threadPool = java.util.concurrent.Executors.newCachedThreadPool();
            }
            if (failureEventType == null) {
                failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(threadPool, eventBus, failureEventType, executionContext);
        }
    }

    private final @Nullable Executor threadPool;
    private final @Nullable EventBus eventBus;
    private final @Nullable Class<?> failureEventType;
    private final Object scope;

    private AsyncExecutor(@Nullable Executor threadPool, @Nullable EventBus eventBus, @Nullable Class<?> failureEventType, Object scope) {
        this.threadPool = threadPool;
        this.eventBus = eventBus;
        this.scope = scope;
        try {
            if (failureEventType != null) {
                failureEventConstructor = failureEventType.getConstructor(Throwable.class);
            }
        } catch (NoSuchMethodException e) {
            // Implementation omitted
        }
    }

    private java.lang.reflect.Constructor<?> failureEventConstructor;

    public void execute(final RunnableEx runnable) {
        if (threadPool != null) {
            threadPool.execute(() -> {
                try {
                    // Implementation omitted
                } catch (Exception e1) {
                    if (eventBus != null) {
                        eventBus.getLogger().log(java.util.logging.Level.SEVERE, "Original exception:", e1);
                    }
                    throw new RuntimeException("Could not create failure event", e1);
                }
            });
        }
    }
}

class RunnableEx implements Runnable {
    @Override
    public void run() {
        // Implementation omitted
    }
}

class ThrowableFailureEvent {
    // Implementation omitted
}
