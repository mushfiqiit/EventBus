package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

final class Subscription {

    @Nonnull
    final SubscriberMethod subscriberMethod;

    Subscription(@Nonnull Object subscriber, @Nonnull SubscriberMethod subscriberMethod) {
        this.subscriberMethod = subscriberMethod;
        throw new java.lang.Error();
    }
}
