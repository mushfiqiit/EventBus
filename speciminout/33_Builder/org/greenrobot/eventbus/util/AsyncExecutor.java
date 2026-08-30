package org.greenrobot.eventbus.util;

import java.util.concurrent.Executor;
import org.greenrobot.eventbus.EventBus;

public class AsyncExecutor {

  public static class Builder {

    private Executor threadPool;

    private Class<?> failureEventType;

    private EventBus eventBus;

    private Builder() {}
  }
}
