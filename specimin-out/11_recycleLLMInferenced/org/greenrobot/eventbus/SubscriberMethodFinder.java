package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class SubscriberMethodFinder {

    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new java.util.HashMap<>();

    private final boolean ignoreGeneratedIndex = false;

    @Nonnull
    List<SubscriberMethod> findSubscriberMethods(@Nonnull Class<?> subscriberClass) {
        @Nullable List<SubscriberMethod> subscriberMethods = METHOD_CACHE.get(subscriberClass);
        if (subscriberMethods != null) {
            return subscriberMethods;
        }
        if (ignoreGeneratedIndex) {
            subscriberMethods = findUsingReflection(subscriberClass);
        } else {
            subscriberMethods = findUsingInfo(subscriberClass);
        }
        if (subscriberMethods.isEmpty()) {
            throw new EventBusException("Subscriber " + subscriberClass + " and its super classes have no public methods with the @Subscribe annotation");
        } else {
            METHOD_CACHE.put(subscriberClass, subscriberMethods);
            return subscriberMethods;
        }
    }

    @Nonnull
    private List<SubscriberMethod> findUsingInfo(@Nonnull Class<?> subscriberClass) {
        throw new java.lang.Error();
    }

    @Nonnull
    private List<SubscriberMethod> findUsingReflection(@Nonnull Class<?> subscriberClass) {
        throw new java.lang.Error();
    }

    static class FindState {

        final @Nonnull List<SubscriberMethod> subscriberMethods;

        final @Nonnull Map<Class, Object> anyMethodByEventType;

        final @Nonnull Map<String, Class> subscriberClassByMethodKey;

        final @Nonnull StringBuilder methodKeyBuilder;

        @Nullable Class<?> subscriberClass;

        @Nullable Class<?> clazz;

        boolean skipSuperClasses;

        @Nullable SubscriberInfo subscriberInfo;

        void recycle() {
            subscriberMethods.clear();
            anyMethodByEventType.clear();
            subscriberClassByMethodKey.clear();
            methodKeyBuilder.setLength(0);
            subscriberClass = null;
            clazz = null;
            skipSuperClasses = false;
            subscriberInfo = null;
        }

        boolean checkAdd(@Nonnull Method method, @Nonnull Class<?> eventType) {
            @Nullable Object existing = anyMethodByEventType.put(eventType, method);
            if (existing == null) {
                return true;
            } else {
                if (existing instanceof Method) {
                    if (!checkAddWithMethodSignature((Method) existing, eventType)) {
                        throw new IllegalStateException();
                    }
                    anyMethodByEventType.put(eventType, this);
                }
                return checkAddWithMethodSignature(method, eventType);
            }
        }

        private boolean checkAddWithMethodSignature(@Nonnull Method method, @Nonnull Class<?> eventType) {
            methodKeyBuilder.setLength(0);
            methodKeyBuilder.append(method.getName());
            methodKeyBuilder.append(']').append(eventType.getName());
            String methodKey = methodKeyBuilder.toString();
            Class<?> methodClass = method.getDeclaringClass();
            @Nullable Class<?> methodClassOld = subscriberClassByMethodKey.put(methodKey, methodClass);
            if (methodClassOld == null || methodClassOld.isAssignableFrom(methodClass)) {
                return true;
            } else {
                subscriberClassByMethodKey.put(methodKey, methodClassOld);
                return false;
            }
        }

        void moveToSuperclass() {
            if (skipSuperClasses) {
                clazz = null;
            } else {
                clazz = clazz.getSuperclass();
                String clazzName = clazz.getName();
                if (clazzName.startsWith("java.") || clazzName.startsWith("javax.") || clazzName.startsWith("android.") || clazzName.startsWith("androidx.")) {
                    clazz = null;
                }
            }
        }
    }
}
