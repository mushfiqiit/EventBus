package org.greenrobot.eventbus.android;

@SuppressWarnings("TryWithIdenticalCatches")
public class AndroidDependenciesDetector {

  private static final String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME = null;

  public static AndroidComponents instantiateAndroidComponents() {
    try {
      Class<?> impl = Class.forName(ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME);
      return (AndroidComponents) impl.getConstructor().newInstance();
    } catch (Throwable ex) {
      return null;
    }
  }
}
