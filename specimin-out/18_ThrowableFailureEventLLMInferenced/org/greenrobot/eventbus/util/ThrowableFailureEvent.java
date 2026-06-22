package org.greenrobot.eventbus.util;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public class ThrowableFailureEvent implements HasExecutionScope {

    protected final @Nonnull Throwable throwable;

    protected final boolean suppressErrorUi;

    private @Nullable Object executionContext;

    public ThrowableFailureEvent(@Nonnull Throwable throwable, boolean suppressErrorUi) {
        this.throwable = throwable;
        this.suppressErrorUi = suppressErrorUi;
    }
}
