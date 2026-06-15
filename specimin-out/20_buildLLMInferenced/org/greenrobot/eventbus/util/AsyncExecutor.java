package org.greenrobot.eventbus.util;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AsyncExecutor {

    public static class Builder {

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        @Nonnull
        public AsyncExecutor buildForScope(@Nullable Object executionContext) {
            throw new java.lang.Error();
        }
    }
}
