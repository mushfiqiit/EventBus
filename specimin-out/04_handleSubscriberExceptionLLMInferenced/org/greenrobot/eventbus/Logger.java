package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import java.util.logging.Level;
import javax.annotation.Nullable;

public interface Logger {

    default void log(Level level, @Nonnull String msg, @Nullable Throwable th) {
        throw new java.lang.Error();
    }
}
