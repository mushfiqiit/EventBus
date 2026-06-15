package org.greenrobot.eventbus.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThrowableFailureEvent implements HasExecutionScope {

    protected final @Nonnull Throwable throwable;

    protected final boolean suppressErrorUi;

    private @Nullable Object executionContext;

    public ThrowableFailureEvent(@Nonnull Throwable throwable, boolean suppressErrorUi) {
        this.throwable = throwable;
        this.suppressErrorUi = suppressErrorUi;
    }
}
