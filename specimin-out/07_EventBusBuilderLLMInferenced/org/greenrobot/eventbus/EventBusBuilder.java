package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SuppressWarnings("unused")
public class EventBusBuilder {

    private final static @Nullable ExecutorService DEFAULT_EXECUTOR_SERVICE;

    boolean logSubscriberExceptions;

    boolean logNoSubscriberMessages;

    boolean sendSubscriberExceptionEvent;

    boolean sendNoSubscriberEvent;

    boolean throwSubscriberException;

    boolean eventInheritance;

    boolean ignoreGeneratedIndex;

    boolean strictMethodVerification;

    @Nullable ExecutorService executorService;

    @Nullable List<Class<?>> skipMethodVerificationForClasses;

    @Nullable List<SubscriberInfoIndex> subscriberInfoIndexes;

    @Nullable Logger logger;

    @Nullable MainThreadSupport mainThreadSupport;

    EventBusBuilder() {
    }
}
