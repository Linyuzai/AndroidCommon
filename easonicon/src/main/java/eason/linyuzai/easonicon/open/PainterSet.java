package eason.linyuzai.easonicon.open;

import java.util.List;

public interface PainterSet extends Painter {
    /**
     * 获得Painter List
     *
     * @return Painter List
     */
    List<Painter> getPainters();

    /**
     * 获得Painter
     *
     * @param index Painter的位置
     * @return Painter
     */
    Painter getPainter(int index);

    /**
     * 添加Painter
     *
     * @param painter 需要添加的Painter
     */
    void addPainter(Painter painter);

    /**
     * 添加Painter
     *
     * @param index   添加的位置
     * @param painter 需要添加的Painter
     */
    void addPainter(int index, Painter painter);

    /**
     * 移除Painter
     *
     * @param painter 需要移除的Painter
     */
    void removePainter(Painter painter);

    /**
     * 移除Painter
     *
     * @param index 需要移除的位置
     */
    void removePainter(int index);

    /**
     * 清除Painter List
     */
    void clearPainter();

    /**
     * 获得Interceptor List
     *
     * @return Interceptor List
     */
    List<PainterInterceptor> getInterceptors();

    /**
     * 添加Interceptor
     *
     * @param interceptor 需要添加的Interceptor
     */
    void addInterceptor(PainterInterceptor interceptor);

    /**
     * 添加Interceptor
     *
     * @param interceptor  需要添加的Interceptor
     * @param recursiveSet 递归设置
     */
    void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet);

    /**
     * 添加Interceptor
     *
     * @param index       添加的位置
     * @param interceptor 需要添加的Interceptor
     */
    void addInterceptor(int index, PainterInterceptor interceptor);

    /**
     * 添加Interceptor
     *
     * @param index        添加的位置
     * @param interceptor  需要添加的Interceptor
     * @param recursiveSet 递归设置
     */
    void addInterceptor(int index, PainterInterceptor interceptor, boolean recursiveSet);

    /**
     * 移除Interceptor
     *
     * @param interceptor 需要移除的Interceptor
     */
    void removeInterceptor(PainterInterceptor interceptor);

    /**
     * 移除Interceptor
     *
     * @param interceptor  需要移除的Interceptor
     * @param recursiveSet 递归移除
     */
    void removeInterceptor(PainterInterceptor interceptor, boolean recursiveSet);

    /**
     * 移除Interceptor
     *
     * @param index 需要移除的位置
     */
    void removeInterceptor(int index);

    /**
     * 移除Interceptor
     *
     * @param index        需要移除的位置
     * @param recursiveSet 递归移除
     */
    void removeInterceptor(int index, boolean recursiveSet);

    /**
     * 清除Interceptor
     */
    void clearInterceptor();

    /**
     * 清除Interceptor
     *
     * @param recursiveSet 递归清除
     */
    void clearInterceptor(boolean recursiveSet);

    /**
     * 递归Painter
     *
     * @param callback 回调
     */
    void recursivePainter(OnRecursivePainterCallback callback);

    /**
     * 获得默认百分比
     *
     * @return 默认百分比
     */
    float getDefaultPercent();

    /**
     * 递归Painter回调接口
     */
    @FunctionalInterface
    interface OnRecursivePainterCallback {
        void onPainterRecursive(Painter painter);
    }
}
