package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

final class Subscription {

    @Nonnull
    final Object subscriber;

    @Nonnull
    final SubscriberMethod subscriberMethod;
}
