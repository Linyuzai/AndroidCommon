package eason.linyuzai.easonicon.painter;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.ArcSupport;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

public class SupportEasonPainterSet extends EasonPainterSet {

    public static final float NOT_SUPPORT_FLOAT = Float.NaN;
    public static final int NOT_SUPPORT_COLOR = -1;

    private ArcSupport arcSupport;
    private Painter auxiliaryScalePainter;
    private AuxiliaryColorInterceptor auxiliaryColorInterceptor;
    private RoundRectSupport roundRectSupport;

    @Override
    public void addPainter(Painter painter) {
        if (painter.isSupportArc())
            setArcSupport(painter.toArcSupport());
        if (painter.isSupportRoundRect())
            setRoundRectSupport(painter.toRoundRectSupport());
        super.addPainter(painter);
    }

    @Override
    public void addPainter(int index, Painter painter) {
        if (painter.isSupportArc())
            setArcSupport(painter.toArcSupport());
        if (painter.isSupportRoundRect())
            setRoundRectSupport(painter.toRoundRectSupport());
        super.addPainter(index, painter);
    }

    @Override
    public void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor instanceof AuxiliaryColorInterceptor)
            setAuxiliaryColorInterceptor((AuxiliaryColorInterceptor) interceptor);
        super.addInterceptor(interceptor, recursiveSet);
    }

    @Override
    public void addInterceptor(int index, PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor instanceof AuxiliaryColorInterceptor)
            setAuxiliaryColorInterceptor((AuxiliaryColorInterceptor) interceptor);
        super.addInterceptor(index, interceptor, recursiveSet);
    }

    //-------arc---------//

    public ArcSupport getArcSupport() {
        return arcSupport;
    }

    public void setArcSupport(ArcSupport arcSupport) {
        this.arcSupport = arcSupport;
    }

    public float getStartAngle() {
        if (isSupportArc())
            return arcSupport.getStartAngle();
        return NOT_SUPPORT_FLOAT;
    }

    public void setStartAngle(float startAngle) {
        if (isSupportArc())
            arcSupport.setStartAngle(startAngle);
    }

    public float getSweepAngle() {
        if (isSupportArc())
            return arcSupport.getSweepAngle();
        return NOT_SUPPORT_FLOAT;
    }

    public void setSweepAngle(float sweepAngle) {
        if (isSupportArc())
            arcSupport.setSweepAngle(sweepAngle);
    }

    public boolean isUseCenter() {
        return isSupportArc() && arcSupport.isUseCenter();
    }

    public void setUseCenter(boolean useCenter) {
        if (isSupportArc())
            arcSupport.setUseCenter(useCenter);
    }

    //-------arc---------//
    //-------auxiliaryScale---------//

    public Painter getAuxiliaryScalePainter() {
        return auxiliaryScalePainter;
    }

    public void setAuxiliaryScalePainter(Painter auxiliaryScalePainter) {
        this.auxiliaryScalePainter = auxiliaryScalePainter;
    }

    public float getAuxiliaryScale() {
        if (isSupportAuxiliaryScale() &&
                auxiliaryScalePainter.getPercentX() == auxiliaryScalePainter.getPercentY() &&
                auxiliaryScalePainter.getOffsetPercentX() == auxiliaryScalePainter.getOffsetPercentY() &&
                auxiliaryScalePainter.getOffsetX() == 0f && auxiliaryScalePainter.getOffsetY() == 0f)
            return auxiliaryScalePainter.getPercentX();
        return NOT_SUPPORT_FLOAT;
    }

    public void setAuxiliaryScale(float scale) {
        if (isSupportAuxiliaryScale())
            auxiliaryScalePainter.setCenterPercent(scale);
    }

    //-------auxiliaryScale---------//
    //-------auxiliaryColor---------//

    public void setAuxiliaryColorInterceptor(AuxiliaryColorInterceptor auxiliaryColorInterceptor) {
        this.auxiliaryColorInterceptor = auxiliaryColorInterceptor;
    }

    public AuxiliaryColorInterceptor getAuxiliaryColorInterceptor() {
        return auxiliaryColorInterceptor;
    }

    public int getAuxiliaryColor() {
        if (isSupportAuxiliaryColor())
            return auxiliaryColorInterceptor.getAuxiliaryColor();
        return NOT_SUPPORT_COLOR;
    }

    public void setAuxiliaryColor(int color) {
        if (isSupportAuxiliaryColor())
            auxiliaryColorInterceptor.setAuxiliaryColor(color);
    }

    //-------auxiliaryColor---------//
    //-------roundRect---------//

    public void setRoundRectSupport(RoundRectSupport roundRectSupport) {
        this.roundRectSupport = roundRectSupport;
    }

    public RoundRectSupport getRoundRectSupport() {
        return roundRectSupport;
    }

    public float getLeftTop() {
        if (isSupportRoundRect())
            return roundRectSupport.getLeftTop();
        return NOT_SUPPORT_FLOAT;
    }

    public void setLeftTop(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setLeftTop(r);
    }

    public float getRightTop() {
        if (isSupportRoundRect())
            return roundRectSupport.getRightTop();
        return NOT_SUPPORT_FLOAT;
    }

    public void setRightTop(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setRightTop(r);
    }

    public float getLeftBottom() {
        if (isSupportRoundRect())
            return roundRectSupport.getLeftBottom();
        return NOT_SUPPORT_FLOAT;
    }

    public void setLeftBottom(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setLeftBottom(r);
    }

    public float getRightBottom() {
        if (isSupportRoundRect())
            return roundRectSupport.getRightBottom();
        return NOT_SUPPORT_FLOAT;
    }

    public void setRightBottom(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setRightBottom(r);
    }

    //-------roundRect---------//
}
