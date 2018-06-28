package eason.linyuzai.easonicon.painter.interceptor.rect;

import android.graphics.RectF;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;

/**
 * 支持PainterSet缩放平移拦截器
 */
public class PainterSetRectSupportInterceptor extends RectInterceptor {

    private float percentX = 1f;
    private float percentY = 1f;

    private float offsetX = 0f;
    private float offsetY = 0f;

    private float offsetPercentX = 0f;
    private float offsetPercentY = 0f;

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
        rectF.right = restoreRectF.left + restoreRectF.width() * percentX;
        rectF.bottom = restoreRectF.top + restoreRectF.height() * percentY;
        rectF.top += offsetPercentY * restoreRectF.height() + offsetY;
        rectF.left += offsetPercentX * restoreRectF.width() + offsetX;
        rectF.right += offsetPercentX * restoreRectF.width() + offsetX;
        rectF.bottom += offsetPercentY * restoreRectF.height() + offsetY;
    }

    protected void restoreRect(RectF rectF) {
        rectF.top = restoreRectF.top;
        rectF.left = restoreRectF.left;
        rectF.right = restoreRectF.right;
        rectF.bottom = restoreRectF.bottom;
    }

    /**
     * @see EasonPainterSet#setCenterPercent(float)
     */
    public void setCenterPercent(float centerPercent) {
        setPercent(centerPercent);
        setOffsetPercent((1f - centerPercent) * 0.5f);
    }

    /**
     * @see EasonPainterSet#setPercent(float)
     */
    public void setPercent(float percent) {
        setPercentX(percent);
        setPercentY(percent);
    }

    /**
     * @see EasonPainterSet#setOffset(float)
     */
    public void setOffset(float offset) {
        setOffsetX(offset);
        setOffsetY(offset);
    }

    /**
     * @see EasonPainterSet#setOffsetPercent(float)
     */
    public void setOffsetPercent(float offsetPercent) {
        setOffsetPercentX(offsetPercent);
        setOffsetPercentY(offsetPercent);
    }

    /**
     * @see EasonPainterSet#getPercentX()
     */
    public float getPercentX() {
        return percentX;
    }

    /**
     * @see EasonPainterSet#setPercentX(float)
     */
    public void setPercentX(float percentX) {
        this.percentX = percentX;
    }

    /**
     * @see EasonPainterSet#getPercentY()
     */
    public float getPercentY() {
        return percentY;
    }

    /**
     * @see EasonPainterSet#setPercentY(float)
     */
    public void setPercentY(float percentY) {
        this.percentY = percentY;
    }

    /**
     * @see EasonPainterSet#getOffsetX()
     */
    public float getOffsetX() {
        return offsetX;
    }

    /**
     * @see EasonPainterSet#setOffsetX(float)
     */
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    /**
     * @see EasonPainterSet#getOffsetY()
     */
    public float getOffsetY() {
        return offsetY;
    }

    /**
     * @see EasonPainterSet#setOffsetY(float)
     */
    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * @see EasonPainterSet#getOffsetPercentX()
     */
    public float getOffsetPercentX() {
        return offsetPercentX;
    }

    /**
     * @see EasonPainterSet#setOffsetPercentX(float)
     */
    public void setOffsetPercentX(float offsetPercentX) {
        this.offsetPercentX = offsetPercentX;
    }

    /**
     * @see EasonPainterSet#getOffsetPercentY()
     */
    public float getOffsetPercentY() {
        return offsetPercentY;
    }

    /**
     * @see EasonPainterSet#setOffsetPercentY(float)
     */
    public void setOffsetPercentY(float offsetPercentY) {
        this.offsetPercentY = offsetPercentY;
    }
}
