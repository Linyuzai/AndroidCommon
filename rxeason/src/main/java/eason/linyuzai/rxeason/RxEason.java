package eason.linyuzai.rxeason;

import android.view.View;

import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.BackpressureStrategy;

public class RxEason {

    public static BackpressureStrategy globalBackpressureStrategy = BackpressureStrategy.BUFFER;

    public static ViewListenerSetter view(View... views) {
        return new ViewListenerSetter(views);
    }
}
