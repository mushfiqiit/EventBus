package org.greenrobot.eventbus;

import java.util.logging.Level;

public interface Logger {

  void log(Level level, String msg);

  class Default {

    public static Logger get() {
      throw new java.lang.Error();
    }
  }
}
