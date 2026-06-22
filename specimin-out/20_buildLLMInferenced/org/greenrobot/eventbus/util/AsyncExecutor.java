package org.greenrobot.eventbus.util;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public class AsyncExecutor {

    public static class Builder {

        public @Nonnull AsyncExecutor build() {
            return buildForScope(null);
        }

        public @Nonnull AsyncExecutor buildForScope(@Nullable Object executionContext) {
            throw new java.lang.Error();
        }
    }
}
