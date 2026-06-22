package org.greenrobot.eventbus;

import java.util.logging.Level;

public interface Logger {

    default void log(Level level, String msg) {
        throw new java.lang.Error();
    }

    class Default {

        public static Logger get() {
            throw new java.lang.Error();
        }
    }
}
