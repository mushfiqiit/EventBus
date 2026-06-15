package org.greenrobot.eventbus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

import javax.annotation.Nullable;

public class EventBus {

    public static String TAG;

    static volatile EventBus defaultInstance;

    private static final EventBusBuilder DEFAULT_BUILDER;

    private static final Map<Class<?>, List<Class<?>>> eventTypesCache;

    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;

    private final Map<Object, List<Class<?>>> typesBySubscriber;

    private final Map<Class<?>, Object> stickyEvents;

    private final ThreadLocal<PostingThreadState> currentPostingThreadState;

    private final MainThreadSupport mainThreadSupport;

    private final Poster mainThreadPoster;

    private final BackgroundPoster backgroundPoster;

    private final AsyncPoster asyncPoster;

    private final SubscriberMethodFinder subscriberMethodFinder;

    private final ExecutorService executorService;

    private final boolean throwSubscriberException;

    private final boolean logSubscriberExceptions;

    private final boolean logNoSubscriberMessages;

    private final boolean sendSubscriberExceptionEvent;

    private final boolean sendNoSubscriberEvent;

    private final boolean eventInheritance;

    private final int indexCount;

    private final Logger logger;

    EventBus(EventBusBuilder builder) {
        logger = builder.getLogger();
        subscriptionsByEventType = new HashMap<>();
        typesBySubscriber = new HashMap<>();
        stickyEvents = new ConcurrentHashMap<>();
        mainThreadSupport = builder.getMainThreadSupport();
        mainThreadPoster = mainThreadSupport != null ? mainThreadSupport.createPoster(this) : null;
        backgroundPoster = new BackgroundPoster(this);
        asyncPoster = new AsyncPoster(this);
        indexCount = builder.subscriberInfoIndexes != null ? builder.subscriberInfoIndexes.size() : 0;
        subscriberMethodFinder = new SubscriberMethodFinder(builder.subscriberInfoIndexes, builder.strictMethodVerification, builder.ignoreGeneratedIndex);
        logSubscriberExceptions = builder.logSubscriberExceptions;
        logNoSubscriberMessages = builder.logNoSubscriberMessages;
        sendSubscriberExceptionEvent = builder.sendSubscriberExceptionEvent;
        sendNoSubscriberEvent = builder.sendNoSubscriberEvent;
        throwSubscriberException = builder.throwSubscriberException;
        eventInheritance = builder.eventInheritance;
        executorService = builder.executorService;
    }

    final static class PostingThreadState {
    }
}
