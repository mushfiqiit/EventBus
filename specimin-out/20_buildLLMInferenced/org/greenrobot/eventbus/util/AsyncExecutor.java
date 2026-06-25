package org.greenrobot.eventbus.util;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public class AsyncExecutor {

    public static class Builder {

        @Nonnull
        public AsyncExecutor build() {
            return buildForScope(null);
        }

        @Nonnull
        public AsyncExecutor buildForScope(@Nullable Object executionContext) {
            throw new java.lang.Error();
        }
    }
}
