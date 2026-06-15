package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EventBus {

    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;

    private final Map<Object, List<Class<?>>> typesBySubscriber;

    private final Map<Class<?>, Object> stickyEvents;

    private final boolean eventInheritance = false;

    private void subscribe(@Nonnull Object subscriber, @Nonnull SubscriberMethod subscriberMethod) {
        @Nonnull Class<?> eventType = subscriberMethod.eventType;
        @Nonnull Subscription newSubscription = new Subscription(subscriber, subscriberMethod);
        @Nullable CopyOnWriteArrayList<Subscription> subscriptions = subscriptionsByEventType.get(eventType);
        if (subscriptions == null) {
            subscriptions = new CopyOnWriteArrayList<>();
            subscriptionsByEventType.put(eventType, subscriptions);
        } else {
            if (subscriptions.contains(newSubscription)) {
                throw new EventBusException("Subscriber " + subscriber.getClass() + " already registered to event " + eventType);
            }
        }
        int size = subscriptions.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.priority > subscriptions.get(i).subscriberMethod.priority) {
                subscriptions.add(i, newSubscription);
                break;
            }
        }
        @Nullable List<Class<?>> subscribedEvents = typesBySubscriber.get(subscriber);
        if (subscribedEvents == null) {
            subscribedEvents = new ArrayList<>();
            typesBySubscriber.put(subscriber, subscribedEvents);
        }
        subscribedEvents.add(eventType);
        if (subscriberMethod.sticky) {
            if (eventInheritance) {
                @Nonnull Set<Map.Entry<Class<?>, Object>> entries = stickyEvents.entrySet();
                for (@Nonnull Map.Entry<Class<?>, Object> entry : entries) {
                    @Nonnull Class<?> candidateEventType = entry.getKey();
                    if (eventType.isAssignableFrom(candidateEventType)) {
                        @Nullable Object stickyEvent = entry.getValue();
                        checkPostStickyEventToSubscription(newSubscription, stickyEvent);
                    }
                }
            } else {
                @Nullable Object stickyEvent = stickyEvents.get(eventType);
                checkPostStickyEventToSubscription(newSubscription, stickyEvent);
            }
        }
    }

    private void checkPostStickyEventToSubscription(@Nonnull Subscription newSubscription, @Nullable Object stickyEvent) {
        throw new java.lang.Error();
    }
}
