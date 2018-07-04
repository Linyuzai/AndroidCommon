package eason.linyuzai.elib.component;

import eason.linyuzai.elib.common.EasonMemory;

public interface EasonContext {
    void toast(Object o);

    void log(Object o);

    int dip(int dipValue);

    EasonMemory memory();
}
