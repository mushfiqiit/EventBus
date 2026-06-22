package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

final class Subscription {

    @Nonnull
    final Object subscriber;

    @Nonnull
    final SubscriberMethod subscriberMethod;

    volatile boolean active;

    Subscription(@Nonnull Object subscriber, @Nonnull SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }
}
