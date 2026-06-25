package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    private final @Nullable Class<? extends SubscriberInfo> superSubscriberInfoClass;

    public @Nullable SubscriberInfo getSuperSubscriberInfo() {
        if (superSubscriberInfoClass == null) {
            return null;
        }
        try {
            return superSubscriberInfoClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
