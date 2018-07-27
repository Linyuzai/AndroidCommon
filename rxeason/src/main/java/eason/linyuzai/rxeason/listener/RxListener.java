package eason.linyuzai.rxeason.listener;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eason.linyuzai.rxeason.listener.textview.TextViewListenerSetter;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import eason.linyuzai.rxeason.listener.viewgroup.ViewGroupListenerSetter;
import io.reactivex.BackpressureStrategy;

public class RxListener {
    private static BackpressureStrategy listenerBackpressureStrategy = BackpressureStrategy.BUFFER;

    public static BackpressureStrategy getListenerBackpressureStrategy() {
        return listenerBackpressureStrategy;
    }

    public static void setListenerBackpressureStrategy(BackpressureStrategy listenerBackpressureStrategy) {
        RxListener.listenerBackpressureStrategy = listenerBackpressureStrategy;
    }

    public TextViewListenerSetter textView(TextView... textViews) {
        TextViewListenerSetter setter = new TextViewListenerSetter();
        setter.bind(textViews);
        return setter;
    }

    public ViewListenerSetter view(View... views) {
        ViewListenerSetter setter = new ViewListenerSetter();
        setter.bind(views);
        return setter;
    }

    public ViewGroupListenerSetter viewGroup(ViewGroup... viewGroups) {
        ViewGroupListenerSetter setter = new ViewGroupListenerSetter();
        setter.bind(viewGroups);
        return setter;
    }
}
