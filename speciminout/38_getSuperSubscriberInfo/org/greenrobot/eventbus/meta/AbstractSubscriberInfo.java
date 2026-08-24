package org.greenrobot.eventbus.meta;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    private final Class<? extends SubscriberInfo> superSubscriberInfoClass = null;

    public SubscriberInfo getSuperSubscriberInfo() {
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
