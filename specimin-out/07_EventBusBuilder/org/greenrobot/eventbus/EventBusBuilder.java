package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SuppressWarnings("unused")
public class EventBusBuilder {

    private final static ExecutorService DEFAULT_EXECUTOR_SERVICE;

    boolean logSubscriberExceptions;

    boolean logNoSubscriberMessages;

    boolean sendSubscriberExceptionEvent;

    boolean sendNoSubscriberEvent;

    boolean throwSubscriberException;

    boolean eventInheritance;

    boolean ignoreGeneratedIndex;

    boolean strictMethodVerification;

    ExecutorService executorService;

    List<Class<?>> skipMethodVerificationForClasses;

    List<SubscriberInfoIndex> subscriberInfoIndexes;

    Logger logger;

    MainThreadSupport mainThreadSupport;

    EventBusBuilder() {
    }
}
