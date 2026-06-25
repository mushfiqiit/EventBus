package org.greenrobot.eventbus.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThrowableFailureEvent implements HasExecutionScope {

    protected final Throwable throwable;

    protected final boolean suppressErrorUi;

    private @Nullable Object executionContext;

    public ThrowableFailureEvent(@Nonnull Throwable throwable) {
        this.throwable = throwable;
        suppressErrorUi = false;
    }

    // Additional constructor from field usage context
    public ThrowableFailureEvent(@Nonnull Throwable throwable, boolean suppressErrorUi) {
        this.throwable = throwable;
        this.suppressErrorUi = suppressErrorUi;
    }

    public @Nonnull Throwable getThrowable() {
        return throwable;
    }

    public boolean isSuppressErrorUi() {
        return suppressErrorUi;
    }

    public @Nullable Object getExecutionScope() {
        return executionContext;
    }

    public void setExecutionScope(@Nullable Object executionContext) {
        this.executionContext = executionContext;
    }
}
