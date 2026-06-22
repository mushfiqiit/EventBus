package org.greenrobot.eventbus.util;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ExceptionToResourceMapping {

    public final @Nullable Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    @Nullable
    protected Integer mapThrowableFlat(@Nonnull Throwable throwable) {
        @Nonnull Class<? extends Throwable> throwableClass = throwable.getClass();
        @Nullable Integer resId = throwableToMsgIdMap != null ? throwableToMsgIdMap.get(throwableClass) : null;
        if (resId == null) {
            @Nullable Class<? extends Throwable> closestClass = null;
            if (throwableToMsgIdMap != null) {
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
        }
        return resId;
    }

    @Nonnull
    public ExceptionToResourceMapping addMapping(@Nonnull Class<? extends Throwable> clazz, int msgId) {
        if (throwableToMsgIdMap != null) {
            throwableToMsgIdMap.put(clazz, msgId);
        }
        return this;
    }
}
