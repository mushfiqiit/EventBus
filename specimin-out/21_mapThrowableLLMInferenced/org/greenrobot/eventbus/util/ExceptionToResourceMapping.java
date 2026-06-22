package org.greenrobot.eventbus.util;

import org.greenrobot.eventbus.Logger;
import javax.annotation.Nullable;
import java.util.logging.Level;

public class ExceptionToResourceMapping {

    public @Nullable Integer mapThrowable(final Throwable throwable) {
        Throwable throwableToCheck = throwable;
        int depthToGo = 20;
        while (true) {
            @Nullable Integer resId = mapThrowableFlat(throwableToCheck);
            if (resId != null) {
                return resId;
            } else {
                throwableToCheck = throwableToCheck.getCause();
                depthToGo--;
                if (depthToGo <= 0 || throwableToCheck == throwable || throwableToCheck == null) {
                    @Nullable Logger logger = Logger.Default.get();
                    logger.log(Level.FINE, "No specific message resource ID found for " + throwable);
                    return null;
                }
            }
        }
    }

    protected @Nullable Integer mapThrowableFlat(Throwable throwable) {
        throw new java.lang.Error();
    }
}
