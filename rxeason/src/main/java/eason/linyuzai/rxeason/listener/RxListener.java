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
        return new TextViewListenerSetter<>().bind(textViews);
    }

    public ViewListenerSetter view(View... views) {
        return new ViewListenerSetter<>().bind(views);
    }

    public ViewGroupListenerSetter viewGroup(ViewGroup... viewGroups) {
        return new ViewGroupListenerSetter<>().bind(viewGroups);
    }
}
