package eason.linyuzai.easonicon.painter;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

public class SupportEasonPainterSet extends EasonPainterSet {

    private Painter auxiliaryScalePainter;
    private AuxiliaryColorInterceptor auxiliaryColorInterceptor;
    private RoundRectSupport roundRectSupport;

    @Override
    public void addPainter(Painter painter) {
        if (painter instanceof RoundRectSupport)
            setRoundRectSupport((RoundRectSupport) painter);
        super.addPainter(painter);
    }

    @Override
    public void addPainter(int index, Painter painter) {
        if (painter instanceof RoundRectSupport)
            setRoundRectSupport((RoundRectSupport) painter);
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

    public Painter getAuxiliaryScalePainter() {
        return auxiliaryScalePainter;
    }

    public void setAuxiliaryScalePainter(Painter auxiliaryScalePainter) {
        this.auxiliaryScalePainter = auxiliaryScalePainter;
    }

    public float getAuxiliaryScale() {
        if (auxiliaryScalePainter.getPercentX() == auxiliaryScalePainter.getPercentY() &&
                auxiliaryScalePainter.getOffsetPercentX() == auxiliaryScalePainter.getOffsetPercentY() &&
                auxiliaryScalePainter.getOffsetX() == 0f && auxiliaryScalePainter.getOffsetY() == 0f)
            return auxiliaryScalePainter.getPercentX();
        return -1f;
    }

    public void setAuxiliaryScale(float scale) {
        auxiliaryScalePainter.setCenterPercent(scale);
    }

    public void setAuxiliaryColorInterceptor(AuxiliaryColorInterceptor auxiliaryColorInterceptor) {
        this.auxiliaryColorInterceptor = auxiliaryColorInterceptor;
    }

    public AuxiliaryColorInterceptor getAuxiliaryColorInterceptor() {
        return auxiliaryColorInterceptor;
    }

    public int getAuxiliaryColor() {
        if (isSupportAuxiliaryColor())
            return auxiliaryColorInterceptor.getAuxiliaryColor();
        return -1;
    }

    public void setAuxiliaryColor(int color) {
        if (isSupportAuxiliaryColor())
            auxiliaryColorInterceptor.setAuxiliaryColor(color);
    }

    public void setRoundRectSupport(RoundRectSupport roundRectSupport) {
        this.roundRectSupport = roundRectSupport;
    }

    public RoundRectSupport getRoundRectSupport() {
        return roundRectSupport;
    }

    public float getLeftTop() {
        if (isSupportRoundRect())
            return roundRectSupport.getLeftTop();
        return -1f;
    }

    public void setLeftTop(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setLeftTop(r);
    }

    public float getRightTop() {
        if (isSupportRoundRect())
            return roundRectSupport.getRightTop();
        return -1f;
    }

    public void setRightTop(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setRightTop(r);
    }

    public float getLeftBottom() {
        if (isSupportRoundRect())
            return roundRectSupport.getLeftBottom();
        return -1f;
    }

    public void setLeftBottom(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setLeftBottom(r);
    }

    public float getRightBottom() {
        if (isSupportRoundRect())
            return roundRectSupport.getRightBottom();
        return -1f;
    }

    public void setRightBottom(float r) {
        if (isSupportRoundRect())
            roundRectSupport.setRightBottom(r);
    }
}
