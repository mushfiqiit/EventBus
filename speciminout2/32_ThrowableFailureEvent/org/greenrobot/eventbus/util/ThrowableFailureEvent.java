package org.greenrobot.eventbus.util;

public class ThrowableFailureEvent implements HasExecutionScope {

  protected final Throwable throwable;

  protected final boolean suppressErrorUi;

  private Object executionContext;

  public ThrowableFailureEvent(Throwable throwable, boolean suppressErrorUi) {
    this.throwable = throwable;
    this.suppressErrorUi = suppressErrorUi;
  }
}
