package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.annotation.Nullable;

public class EventBusBuilder {

    boolean logSubscriberExceptions;

    boolean logNoSubscriberMessages;

    boolean sendSubscriberExceptionEvent;

    boolean sendNoSubscriberEvent;

    boolean throwSubscriberException;

    boolean eventInheritance;

    boolean ignoreGeneratedIndex;

    boolean strictMethodVerification;

    @Nullable
    ExecutorService executorService;

    @Nullable
    List<SubscriberInfoIndex> subscriberInfoIndexes;

    @Nonnull
    Logger getLogger() {
        throw new java.lang.Error();
    }

    @Nullable
    MainThreadSupport getMainThreadSupport() {
        throw new java.lang.Error();
    }
}
