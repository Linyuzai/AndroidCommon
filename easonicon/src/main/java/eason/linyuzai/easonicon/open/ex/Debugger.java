package eason.linyuzai.easonicon.open.ex;

import android.util.Log;

import eason.linyuzai.easonicon.EasonIcon;

public interface Debugger {
    default void debug(Object o) {
        Log.d(EasonIcon.TAG, o + "");
    }
}
