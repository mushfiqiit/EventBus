package org.greenrobot.eventbus.util;

public class AsyncExecutor {

    public static class Builder {

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object executionContext) {
            throw new java.lang.Error();
        }
    }
}
