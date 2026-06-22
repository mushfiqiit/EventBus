package org.greenrobot.eventbus.util;

import org.greenrobot.eventbus.EventBus;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class AsyncExecutor {

    public static class Builder {

        private @Nullable Executor threadPool;

        private @Nullable Class<?> failureEventType;

        private @Nullable EventBus eventBus;

        private Builder() {
        }
    }
}
