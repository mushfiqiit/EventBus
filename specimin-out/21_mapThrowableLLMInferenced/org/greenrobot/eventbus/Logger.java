package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import java.util.logging.Level;

public interface Logger {

    default void log(Level level, String msg) {
        throw new Error();
    }

    class Default {

        public static @Nullable Logger get() {
            throw new java.lang.Error();
        }
    }
}
