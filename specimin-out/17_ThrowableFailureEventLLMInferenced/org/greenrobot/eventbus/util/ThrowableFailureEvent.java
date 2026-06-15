package org.greenrobot.eventbus.util;

import javax.annotation.Nullable;

public class ThrowableFailureEvent implements HasExecutionScope {

    protected final Throwable throwable;

    protected final boolean suppressErrorUi;

    private @Nullable Object executionContext;

    public ThrowableFailureEvent(Throwable throwable) {
        this.throwable = throwable;
        suppressErrorUi = false;
    }
}
