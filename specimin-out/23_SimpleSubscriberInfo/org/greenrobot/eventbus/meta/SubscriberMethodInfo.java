package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo {

    final String methodName;

    final ThreadMode threadMode;

    final Class<?> eventType;

    final int priority = 0;

    final boolean sticky = false;
}
