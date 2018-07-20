package eason.linyuzai.easonicon.open;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.ex.RectSupport;
import eason.linyuzai.easonicon.open.ex.SupportConverter;

/**
 * Created by linyuzai on 2018/5/19.
 *
 * @author linyuzai
 */

public interface Painter extends RectSupport, SupportConverter {

    /**
     * 是否绘制
     *
     * @return 是否绘制
     */
    boolean canDraw();

    /**
     * 设置是否绘制
     *
     * @param canDraw 是否绘制
     */
    void setCanDraw(boolean canDraw);

    /**
     * 绘制
     *
     * @param canvas   画布
     * @param draw     绘制区域
     * @param original 原区域
     * @param paint    画笔
     */
    void draw(Canvas canvas, RectF draw, RectF original, Paint paint);

    /**
     * 绘制位图
     *
     * @param canvas   画布
     * @param bitmap   位图
     * @param draw     绘制区域
     * @param original 原区域
     * @param paint    画笔
     */
    void drawBitmap(Canvas canvas, Bitmap bitmap, RectF draw, RectF original, Paint paint);

    /**
     * 转换成位图
     *
     * @param draw     绘制区域
     * @param original 原区域
     * @param paint    画笔
     * @return 位图
     */
    Bitmap transformBitmap(RectF draw, RectF original, Paint paint);

    /**
     * 获得tag
     *
     * @param <T> tag类型
     * @return tag
     */
    <T> T getTag();

    /**
     * 设置TAG
     *
     * @param <T> tag类型
     * @param tag tag
     */
    <T> void setTag(T tag);

    /**
     * 打印结构
     *
     * @param deep               层次
     * @param includeInterceptor 是否打印Interceptor
     */
    void printStructure(int deep, boolean includeInterceptor);
}
