package eason.linyuzai.rxeason;

import android.content.Context;

import eason.linyuzai.rxeason.event.RxEvent;
import eason.linyuzai.rxeason.listener.RxListener;
import io.reactivex.BackpressureStrategy;

public class RxEason {

    private static BackpressureStrategy globalBackpressureStrategy = BackpressureStrategy.BUFFER;
    private static RxEvent event = new RxEvent();
    private static RxListener listener = new RxListener();

    public static RxEvent event() {
        return event;
    }

    public static RxListener listener() {
        return listener;
    }

    public static RxListener listener(Context context) {
        return listener;
    }

    public static BackpressureStrategy getGlobalBackpressureStrategy() {
        return globalBackpressureStrategy;
    }

    public static void setGlobalBackpressureStrategy(BackpressureStrategy globalBackpressureStrategy) {
        RxEason.globalBackpressureStrategy = globalBackpressureStrategy;
        RxListener.setListenerBackpressureStrategy(globalBackpressureStrategy);
    }
}
