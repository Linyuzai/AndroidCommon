package eason.linyuzai.rxeason.event;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

public class RxEvent {

    private FlowableProcessor<Object> eventBus = PublishProcessor.create().toSerialized();
    private Map<String, Flowable> eventSources = new HashMap<>();

    @SuppressLint("CheckResult")
    public RxEvent() {
        eventBus.onBackpressureBuffer();
    }

    public void publish(String eventName, Flowable eventSource) {
        eventSources.put(eventName, eventSource.share());
    }

    public void abolish(String eventName) {
        eventSources.remove(eventName);
    }

    public Flowable listen(String eventName) {
        return eventSources.get(eventName);
    }

    public void post(Object msg) {
        eventBus.onNext(msg);
    }

    public Flowable receive() {
        return eventBus;
    }

    public <T> Flowable<T> receive(Class<T> cls) {
        return eventBus.ofType(cls);
    }

    public Flowable<EventMessage> receive(int code) {
        return eventBus.filter(msg ->
                msg instanceof EventMessage && ((EventMessage) msg).getMessageCode() == code).cast(EventMessage.class);
    }

    public Flowable<EventMessage> receive(String name) {
        return eventBus.filter(msg ->
                msg instanceof EventMessage && ((EventMessage) msg).getMessageName().equals(name)).cast(EventMessage.class);
    }
}
