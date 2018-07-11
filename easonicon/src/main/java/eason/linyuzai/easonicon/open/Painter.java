package eason.linyuzai.easonicon.open;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.open.support.ArcSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.open.support.RectSupport;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;

/**
 * Created by linyuzai on 2018/5/19.
 *
 * @author linyuzai
 */

public interface Painter extends RectSupport {

    default boolean isSupportArc() {
        return this instanceof ArcSupport;
    }

    default ArcSupport toArcSupport() {
        return (ArcSupport) this;
    }

    default boolean isSupportAuxiliaryScale() {
        return this instanceof AuxiliaryScaleSupport;
    }

    default AuxiliaryScaleSupport toAuxiliaryScaleSupport() {
        return (AuxiliaryScaleSupport) this;
    }

    default boolean isSupportAuxiliaryColor() {
        return this instanceof AuxiliaryColorSupport;
    }

    default AuxiliaryColorSupport toAuxiliaryColorSupport() {
        return (AuxiliaryColorSupport) this;
    }

    default boolean isSupportRoundRect() {
        return this instanceof RoundRectSupport;
    }

    default RoundRectSupport toRoundRectSupport() {
        return (RoundRectSupport) this;
    }

    boolean canDraw();

    void setCanDraw(boolean canDraw);

    void draw(Canvas canvas, RectF draw, RectF original, Paint paint);

    void drawBitmap(Canvas canvas, Bitmap bitmap, RectF draw, RectF original, Paint paint);

    Bitmap transformBitmap(RectF draw, RectF original, Paint paint);

    <T> T getTag();

    /**
     * 设置TAG
     *
     * @param tag tag
     */
    <T> void setTag(T tag);

    void printStructure(int deep, boolean includeInterceptor);
}
