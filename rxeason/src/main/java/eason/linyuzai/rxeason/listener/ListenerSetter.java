package eason.linyuzai.rxeason.listener;

import android.view.View;

import java.util.HashSet;
import java.util.Set;

import io.reactivex.FlowableEmitter;

@SuppressWarnings("unchecked")
public abstract class ListenerSetter<Setter extends ListenerSetter, V extends View, Info extends ListenerInfo<V>> {

    private Set<FlowableEmitter> emitters = new HashSet<>();
    private Info viewInfo;

    public Setter bind(V views) {
        viewInfo = newViewInfo(views);
        return (Setter) this;
    }

    public abstract Info newViewInfo(V view);

    protected Info getViewInfo() {
        return viewInfo;
    }

    public void destroy() {
        for (FlowableEmitter emitter : emitters) {
            emitter.onComplete();
        }
        emitters.clear();
    }
}
