package org.greenrobot.eventbus;

class SubscriberMethodFinder {

  static class FindState {

    Class<?> clazz;

    boolean skipSuperClasses;

    void moveToSuperclass() {
      if (skipSuperClasses) {
        clazz = null;
      } else {
        clazz = clazz.getSuperclass();
        String clazzName = clazz.getName();
        if (clazzName.startsWith("java.")
            || clazzName.startsWith("javax.")
            || clazzName.startsWith("android.")
            || clazzName.startsWith("androidx.")) {
          clazz = null;
        }
      }
    }
  }
}
