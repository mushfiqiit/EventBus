package org.greenrobot.eventbus;

import java.util.logging.Level;
import javax.annotation.Nullable;

public interface Logger {

    default void log(Level level, String msg, @Nullable Throwable th) {
        throw new java.lang.Error();
    }
}
