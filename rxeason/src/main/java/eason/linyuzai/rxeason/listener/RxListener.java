package eason.linyuzai.rxeason.listener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eason.linyuzai.rxeason.listener.textview.TextViewListenerSetter;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import eason.linyuzai.rxeason.listener.viewgroup.ViewGroupListenerSetter;
import io.reactivex.BackpressureStrategy;

public class RxListener {

    private static BackpressureStrategy listenerBackpressureStrategy = BackpressureStrategy.BUFFER;

    private Map<Context, List<ListenerSetter>> setterMap = new HashMap<>();

    public static BackpressureStrategy getListenerBackpressureStrategy() {
        return listenerBackpressureStrategy;
    }

    private <T extends ListenerSetter> T addSetterMap(Context context, T setter) {
        if (setterMap.containsKey(context)) {
            setterMap.get(context).add(setter);
        } else {
            List<ListenerSetter> setters = new ArrayList<>();
            setters.add(setter);
            setterMap.put(context, setters);
        }
        return setter;
    }

    public void destroy(Context context) {
        List<ListenerSetter> setters = setterMap.get(context);
        if (setters == null)
            return;
        for (ListenerSetter setter : setters) {
            setter.destroy();
        }
    }

    public void destroy() {
        for (Context context : setterMap.keySet()) {
            destroy(context);
        }
    }

    public static void setListenerBackpressureStrategy(BackpressureStrategy listenerBackpressureStrategy) {
        RxListener.listenerBackpressureStrategy = listenerBackpressureStrategy;
    }

    public TextViewListenerSetter<?, ?, ?> textView(@NonNull TextView textView) {
        return addSetterMap(textView.getContext(), new TextViewListenerSetter<>().bind(textView));
    }

    public ViewListenerSetter<?, ?, ?> view(@NonNull View view) {
        return addSetterMap(view.getContext(), new ViewListenerSetter<>().bind(view));
    }

    public ViewGroupListenerSetter<?, ?, ?> viewGroup(@NonNull ViewGroup viewGroup) {
        return addSetterMap(viewGroup.getContext(), new ViewGroupListenerSetter<>().bind(viewGroup));
    }
}
