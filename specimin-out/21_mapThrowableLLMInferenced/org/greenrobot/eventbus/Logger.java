package org.greenrobot.eventbus;

import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public interface Logger {

    default void log(@Nonnull Level level, @Nonnull String msg) {
        throw new java.lang.Error();
    }

    class Default {

        public static @Nullable Logger get() {
            throw new java.lang.Error();
        }
    }
}
