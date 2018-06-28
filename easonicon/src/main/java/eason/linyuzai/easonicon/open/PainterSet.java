package eason.linyuzai.easonicon.open;

public interface PainterSet extends Painter {
    void addPainter(Painter painter);

    void addPainter(int index, Painter painter);

    void removePainter(Painter painter);

    void removePainter(int index);

    void clearPainter();

    void addInterceptor(PainterInterceptor interceptor);

    void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet);

    void addInterceptor(int index, PainterInterceptor interceptor);

    void addInterceptor(int index, PainterInterceptor interceptor, boolean recursiveSet);

    void removeInterceptor(PainterInterceptor interceptor);

    void removeInterceptor(PainterInterceptor interceptor, boolean recursiveSet);

    void removeInterceptor(int index);

    void removeInterceptor(int index, boolean recursiveSet);

    void clearInterceptor();

    void clearInterceptor(boolean recursiveSet);
}
