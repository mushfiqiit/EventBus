package org.greenrobot.eventbus.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThrowableFailureEvent implements HasExecutionScope {

    @Nonnull
    protected final Throwable throwable;

    @Nonnull
    protected final boolean suppressErrorUi;

    @Nullable
    private Object executionContext;

    public ThrowableFailureEvent(@Nonnull Throwable throwable) {
        this.throwable = throwable;
        suppressErrorUi = false;
    }
}
