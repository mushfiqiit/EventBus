package org.greenrobot.eventbus.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExceptionToResourceMapping {

    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    protected Integer mapThrowableFlat(Throwable throwable) {
        Class<? extends Throwable> throwableClass = throwable.getClass();
        Integer resId = throwableToMsgIdMap.get(throwableClass);
        if (resId == null) {
            Class<? extends Throwable> closestClass = null;
            Set<Entry<Class<? extends Throwable>, Integer>> mappings = throwableToMsgIdMap.entrySet();
            for (Entry<Class<? extends Throwable>, Integer> mapping : mappings) {
                Class<? extends Throwable> candidate = mapping.getKey();
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

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> clazz, int msgId) {
        throwableToMsgIdMap.put(clazz, msgId);
        return this;
    }
}
