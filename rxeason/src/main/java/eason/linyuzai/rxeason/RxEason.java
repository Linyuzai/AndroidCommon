package eason.linyuzai.rxeason;

import android.view.View;
import android.widget.TextView;

import eason.linyuzai.rxeason.listener.textview.TextViewListenerSetter;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.BackpressureStrategy;

public class RxEason {

    public static BackpressureStrategy globalBackpressureStrategy = BackpressureStrategy.BUFFER;

    public static ViewListenerSetter view(View... views) {
        ViewListenerSetter setter = new ViewListenerSetter();
        setter.bind(views);
        return setter;
    }

    public static TextViewListenerSetter textView(TextView... textViews) {
        TextViewListenerSetter setter = new TextViewListenerSetter();
        setter.bind(textViews);
        return setter;
    }
}
