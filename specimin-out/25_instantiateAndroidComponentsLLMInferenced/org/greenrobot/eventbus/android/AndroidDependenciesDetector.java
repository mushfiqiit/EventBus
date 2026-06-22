package org.greenrobot.eventbus.android;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("TryWithIdenticalCatches")
public class AndroidDependenciesDetector {

    private static final @Nullable String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME;

    public static @Nullable AndroidComponents instantiateAndroidComponents() {
        try {
            @Nonnull Class<?> impl = Class.forName(ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME);
            return (AndroidComponents) impl.getConstructor().newInstance();
        } catch (@Nonnull Throwable ex) {
            return null;
        }
    }
}
