package eason.linyuzai.rxeason;

@Deprecated
public interface BackpressureListener<T> {

    T backpressureBuffer();

    T backpressureDrop();

    T backpressureError();

    T backpressureLatest();

    T backpressureMissing();
}
