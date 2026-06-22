package org.greenrobot.eventbus;

final class Subscription {

    final Object subscriber;

    final SubscriberMethod subscriberMethod;

    volatile boolean active;

    Subscription(Object subscriber, SubscriberMethod subscriberMethod) {
        throw new java.lang.Error();
    }
}
