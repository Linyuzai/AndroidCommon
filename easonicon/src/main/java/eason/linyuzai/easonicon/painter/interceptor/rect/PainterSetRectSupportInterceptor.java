package eason.linyuzai.easonicon.painter.interceptor.rect;

import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.RectSupport;
import eason.linyuzai.easonicon.painter.EasonPainter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;

/**
 * 支持PainterSet缩放平移拦截器
 */
public class PainterSetRectSupportInterceptor extends RectInterceptor implements RectSupport {

    private EasonPainter.RectParam rectParam = new EasonPainter.RectParam();

    private RectF restoreRectF = new RectF();

    @Override
    public void beforeDraw(Painter painter, RectF rectF, int index) {
        saveRect(rectF);
        changeRect(rectF);
    }

    @Override
    public void afterDraw(Painter painter, RectF rectF, int index) {
        restoreRect(rectF);
    }

    /**
     * 保存绘制区域
     *
     * @param rectF rectF
     */
    protected void saveRect(RectF rectF) {
        restoreRectF.top = rectF.top;
        restoreRectF.left = rectF.left;
        restoreRectF.right = rectF.right;
        restoreRectF.bottom = rectF.bottom;
    }

    /**
     * 缩放平移绘制区域
     *
     * @param rectF rectF
     */
    protected void changeRect(RectF rectF) {
        rectF.right = restoreRectF.left + restoreRectF.width() * getPercentX();
        rectF.bottom = restoreRectF.top + restoreRectF.height() * getPercentY();
        rectF.top += getOffsetPercentY() * restoreRectF.height() + getOffsetY();
        rectF.left += getOffsetPercentX() * restoreRectF.width() + getOffsetX();
        rectF.right += getOffsetPercentX() * restoreRectF.width() + getOffsetX();
        rectF.bottom += getOffsetPercentY() * restoreRectF.height() + getOffsetY();
    }

    protected void restoreRect(RectF rectF) {
        rectF.top = restoreRectF.top;
        rectF.left = restoreRectF.left;
        rectF.right = restoreRectF.right;
        rectF.bottom = restoreRectF.bottom;
    }

    /**
     * @see EasonPainterSet#getPercentX()
     */
    public float getPercentX() {
        return rectParam.getPercentX();
    }

    /**
     * @see EasonPainterSet#setPercentX(float)
     */
    public void setPercentX(float percentX) {
        rectParam.setPercentX(percentX);
    }

    /**
     * @see EasonPainterSet#getPercentY()
     */
    public float getPercentY() {
        return rectParam.getPercentY();
    }

    /**
     * @see EasonPainterSet#setPercentY(float)
     */
    public void setPercentY(float percentY) {
        rectParam.setPercentY(percentY);
    }

    /**
     * @see EasonPainterSet#getOffsetX()
     */
    public float getOffsetX() {
        return rectParam.getOffsetX();
    }

    /**
     * @see EasonPainterSet#setOffsetX(float)
     */
    public void setOffsetX(float offsetX) {
        rectParam.setOffsetX(offsetX);
    }

    /**
     * @see EasonPainterSet#getOffsetY()
     */
    public float getOffsetY() {
        return rectParam.getOffsetY();
    }

    /**
     * @see EasonPainterSet#setOffsetY(float)
     */
    public void setOffsetY(float offsetY) {
        rectParam.setOffsetY(offsetY);
    }

    /**
     * @see EasonPainterSet#getOffsetPercentX()
     */
    public float getOffsetPercentX() {
        return rectParam.getOffsetPercentX();
    }

    /**
     * @see EasonPainterSet#setOffsetPercentX(float)
     */
    public void setOffsetPercentX(float offsetPercentX) {
        rectParam.setOffsetPercentX(offsetPercentX);
    }

    /**
     * @see EasonPainterSet#getOffsetPercentY()
     */
    public float getOffsetPercentY() {
        return rectParam.getOffsetPercentY();
    }

    /**
     * @see EasonPainterSet#setOffsetPercentY(float)
     */
    public void setOffsetPercentY(float offsetPercentY) {
        rectParam.setOffsetPercentY(offsetPercentY);
    }
}
