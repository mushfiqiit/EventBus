package org.greenrobot.eventbus.util;

public class ThrowableFailureEvent implements HasExecutionScope {

  protected final Throwable throwable;

  protected final boolean suppressErrorUi;

  private Object executionContext;

  public ThrowableFailureEvent(Throwable throwable) {
    this.throwable = throwable;
    suppressErrorUi = false;
  }
}
