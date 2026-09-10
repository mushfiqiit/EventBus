package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

@SuppressWarnings("unused")
public class EventBusBuilder {

  private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;

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

  EventBusBuilder() {}
}
