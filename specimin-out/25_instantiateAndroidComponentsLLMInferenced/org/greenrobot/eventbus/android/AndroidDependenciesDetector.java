package org.greenrobot.eventbus.android;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@SuppressWarnings("TryWithIdenticalCatches")
public class AndroidDependenciesDetector {

    @Nonnull
    private static final String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME;

    @Nullable
    public static AndroidComponents instantiateAndroidComponents() {
        try {
            @Nonnull Class<?> impl = Class.forName(ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME);
            return (AndroidComponents) impl.getConstructor().newInstance();
        } catch (Throwable ex) {
            return null;
        }
    }
}
