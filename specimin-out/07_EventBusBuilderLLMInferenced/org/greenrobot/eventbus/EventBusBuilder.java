package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class EventBusBuilder {

    private final static @Nonnull ExecutorService DEFAULT_EXECUTOR_SERVICE;

    @Nonnull
    boolean logSubscriberExceptions;

    @Nonnull
    boolean logNoSubscriberMessages;

    @Nonnull
    boolean sendSubscriberExceptionEvent;

    @Nonnull
    boolean sendNoSubscriberEvent;

    @Nonnull
    boolean throwSubscriberException;

    @Nonnull
    boolean eventInheritance;

    @Nonnull
    boolean ignoreGeneratedIndex;

    @Nonnull
    boolean strictMethodVerification;

    @Nullable
    ExecutorService executorService;

    @Nullable
    List<Class<?>> skipMethodVerificationForClasses;

    @Nullable
    List<SubscriberInfoIndex> subscriberInfoIndexes;

    @Nullable
    Logger logger;

    @Nullable
    MainThreadSupport mainThreadSupport;

    EventBusBuilder() {
    }
}
