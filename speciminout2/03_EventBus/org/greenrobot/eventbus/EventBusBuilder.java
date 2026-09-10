package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

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
