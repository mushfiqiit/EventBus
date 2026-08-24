package org.greenrobot.eventbus;

public class ThreadModeReturnType {

    public NameReturnType name() {
        throw new java.lang.Error();
    }
}
