package org.greenrobot.eventbus;

import java.util.logging.Level;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Logger {

    default void log(@Nonnull Level level, @Nonnull String msg, @Nullable Throwable th) {
        throw new java.lang.Error();
    }

    class SystemOutLogger implements Logger {

        public void log(@Nonnull Level level, @Nonnull String msg, @Nullable Throwable th) {
            System.out.println("[" + level + "] " + msg);
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }
}
