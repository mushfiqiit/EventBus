package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

class SubscriberMethodFinder {

    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE;

    private final boolean ignoreGeneratedIndex = false;

    List<SubscriberMethod> findSubscriberMethods(Class<?> subscriberClass) {
        List<SubscriberMethod> subscriberMethods = METHOD_CACHE.get(subscriberClass);
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

    private List<SubscriberMethod> findUsingInfo(Class<?> subscriberClass) {
        throw new java.lang.Error();
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> subscriberClass) {
        throw new java.lang.Error();
    }

    static class FindState {

        final List<SubscriberMethod> subscriberMethods;

        final Map<Class, Object> anyMethodByEventType;

        final Map<String, Class> subscriberClassByMethodKey;

        final StringBuilder methodKeyBuilder;

        Class<?> subscriberClass;

        Class<?> clazz;

        boolean skipSuperClasses;

        SubscriberInfo subscriberInfo;

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

        boolean checkAdd(Method method, Class<?> eventType) {
            Object existing = anyMethodByEventType.put(eventType, method);
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

        private boolean checkAddWithMethodSignature(Method method, Class<?> eventType) {
            methodKeyBuilder.setLength(0);
            methodKeyBuilder.append(method.getName());
            methodKeyBuilder.append('>').append(eventType.getName());
            String methodKey = methodKeyBuilder.toString();
            Class<?> methodClass = method.getDeclaringClass();
            Class<?> methodClassOld = subscriberClassByMethodKey.put(methodKey, methodClass);
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
