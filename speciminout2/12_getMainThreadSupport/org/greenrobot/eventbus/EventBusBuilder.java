package org.greenrobot.eventbus;

import org.greenrobot.eventbus.android.AndroidComponents;

@SuppressWarnings("unused")
public class EventBusBuilder {

  MainThreadSupport mainThreadSupport;

  MainThreadSupport getMainThreadSupport() {
    if (mainThreadSupport != null) {
      return mainThreadSupport;
    } else if (AndroidComponents.areAvailable()) {
      return AndroidComponents.get().defaultMainThreadSupport;
    } else {
      return null;
    }
  }
}
