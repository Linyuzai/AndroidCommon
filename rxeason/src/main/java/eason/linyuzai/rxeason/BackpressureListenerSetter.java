package eason.linyuzai.rxeason;

import io.reactivex.BackpressureStrategy;

@Deprecated
@SuppressWarnings("unchecked")
public class BackpressureListenerSetter<T> implements BackpressureListener<T> {

    private BackpressureStrategy backpressureStrategy = BackpressureStrategy.BUFFER;

    @Override
    public T backpressureBuffer() {
        this.backpressureStrategy = BackpressureStrategy.BUFFER;
        return (T) this;
    }

    @Override
    public T backpressureDrop() {
        this.backpressureStrategy = BackpressureStrategy.DROP;
        return (T) this;
    }

    @Override
    public T backpressureError() {
        this.backpressureStrategy = BackpressureStrategy.ERROR;
        return (T) this;
    }

    @Override
    public T backpressureLatest() {
        this.backpressureStrategy = BackpressureStrategy.LATEST;
        return (T) this;
    }

    @Override
    public T backpressureMissing() {
        this.backpressureStrategy = BackpressureStrategy.MISSING;
        return (T) this;
    }

    public BackpressureStrategy getBackpressureStrategy() {
        return backpressureStrategy;
    }
}
