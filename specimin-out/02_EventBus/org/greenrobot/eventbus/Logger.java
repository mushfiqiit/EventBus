package org.greenrobot.eventbus;

import java.util.logging.Level;

public interface Logger {

    default void log(Level level, String msg) {
        throw new java.lang.Error();
    }

    default void log(Level level, String msg, Throwable th) {
        throw new java.lang.Error();
    }
}
