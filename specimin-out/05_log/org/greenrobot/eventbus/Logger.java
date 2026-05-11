package org.greenrobot.eventbus;

import java.util.logging.Level;
import javax.annotation.Nullable;
public interface Logger {

    default void log(Level level, String msg, @Nullable Throwable th) {
        throw new java.lang.Error();
    }

    class SystemOutLogger implements Logger {

        public void log(Level level, String msg, @Nullable Throwable th) {
            System.out.println("[" + level + "] " + msg);
            th.printStackTrace(System.out);
        }
    }
}
