package org.greenrobot.eventbus.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExceptionToResourceMapping {

    public final @Nonnull Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    protected @Nullable Integer mapThrowableFlat(@Nonnull Throwable throwable) {
        @Nonnull Class<? extends Throwable> throwableClass = throwable.getClass();
        @Nullable Integer resId = throwableToMsgIdMap.get(throwableClass);
        if (resId == null) {
            @Nullable Class<? extends Throwable> closestClass = null;
            @Nonnull Set<Entry<Class<? extends Throwable>, Integer>> mappings = throwableToMsgIdMap.entrySet();
            for (@Nonnull Entry<Class<? extends Throwable>, Integer> mapping : mappings) {
                @Nonnull Class<? extends Throwable> candidate = mapping.getKey();
                if (candidate.isAssignableFrom(throwableClass)) {
                    if (closestClass == null || closestClass.isAssignableFrom(candidate)) {
                        closestClass = candidate;
                        resId = mapping.getValue();
                    }
                }
            }
        }
        return resId;
    }
}
