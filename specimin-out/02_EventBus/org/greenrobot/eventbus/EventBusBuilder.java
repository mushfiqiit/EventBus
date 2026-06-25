package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SuppressWarnings("unused")
public class EventBusBuilder {

    boolean logSubscriberExceptions;

    boolean logNoSubscriberMessages;

    boolean sendSubscriberExceptionEvent;

    boolean sendNoSubscriberEvent;

    boolean throwSubscriberException;

    boolean eventInheritance;

    boolean ignoreGeneratedIndex;

    boolean strictMethodVerification;

    ExecutorService executorService;

    List<SubscriberInfoIndex> subscriberInfoIndexes;

    Logger getLogger() {
        throw new java.lang.Error();
    }

    MainThreadSupport getMainThreadSupport() {
        throw new java.lang.Error();
    }
}
