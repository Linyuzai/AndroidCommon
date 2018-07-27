package eason.linyuzai.rxeason;

import eason.linyuzai.rxeason.listener.RxListener;
import io.reactivex.BackpressureStrategy;

public class RxEason {

    private static BackpressureStrategy globalBackpressureStrategy = BackpressureStrategy.BUFFER;
    private static RxListener listener = new RxListener();

    public static RxListener listener() {
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
