package org.greenrobot.eventbus.util;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ExceptionToResourceMapping {

    public final @Nullable Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    protected @Nullable Integer mapThrowableFlat(@Nonnull Throwable throwable) {
        Class<? extends Throwable> throwableClass = throwable.getClass();
        @Nullable Integer resId = throwableToMsgIdMap != null ? throwableToMsgIdMap.get(throwableClass) : null;
        if (resId == null) {
            @Nullable Class<? extends Throwable> closestClass = null;
            @Nonnull Set<Entry<Class<? extends Throwable>, Integer>> mappings = throwableToMsgIdMap != null ? throwableToMsgIdMap.entrySet() : Set.of();
            for (@Nonnull Entry<Class<? extends Throwable>, Integer> mapping : mappings) {
                Class<? extends Throwable> candidate = mapping.getKey();
                if (candidate.isAssignableFrom(throwableClass)) {
                    if (closestClass == null || (closestClass != null && closestClass.isAssignableFrom(candidate))) {
                        closestClass = candidate;
                        resId = mapping.getValue();
                    }
                }
            }
        }
        return resId;
    }
}
