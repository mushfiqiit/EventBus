package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class EventBus {

    public static String TAG;

    @Nullable
    static volatile EventBus defaultInstance;

    private static final EventBusBuilder DEFAULT_BUILDER;

    private static final Map<Class<?>, List<Class<?>>> eventTypesCache;

    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;

    private final Map<Object, List<Class<?>>> typesBySubscriber;

    private final Map<Class<?>, Object> stickyEvents;

    private final ThreadLocal<PostingThreadState> currentPostingThreadState;

    private final @Nullable MainThreadSupport mainThreadSupport;

    private final @Nullable Poster mainThreadPoster;

    private final @Nonnull BackgroundPoster backgroundPoster;

    private final @Nonnull AsyncPoster asyncPoster;

    private final @Nonnull SubscriberMethodFinder subscriberMethodFinder;

    private final @Nullable ExecutorService executorService;

    private final boolean throwSubscriberException;

    private final boolean logSubscriberExceptions;

    private final boolean logNoSubscriberMessages;

    private final boolean sendSubscriberExceptionEvent;

    private final boolean sendNoSubscriberEvent;

    private final boolean eventInheritance;

    private final int indexCount;

    private final @Nonnull Logger logger;

    @Nonnull
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
