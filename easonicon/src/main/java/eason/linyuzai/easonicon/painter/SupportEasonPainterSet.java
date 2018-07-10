package eason.linyuzai.easonicon.painter;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.painter.combine.interceptor.AuxiliaryColorInterceptor;

public class SupportEasonPainterSet extends EasonPainterSet {
    private RoundRectSupport roundRectSupport;
    private AuxiliaryColorInterceptor auxiliaryColorInterceptor;

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

    public void setAuxiliaryColorInterceptor(AuxiliaryColorInterceptor auxiliaryColorInterceptor) {
        this.auxiliaryColorInterceptor = auxiliaryColorInterceptor;
    }

    public AuxiliaryColorInterceptor getAuxiliaryColorInterceptor() {
        return auxiliaryColorInterceptor;
    }

    public void setAuxiliaryColor(int color) {
        if (auxiliaryColorInterceptor == null)
            return;
        auxiliaryColorInterceptor.setAuxiliaryColor(color);
    }

    public int getAuxiliaryColor() {
        if (auxiliaryColorInterceptor == null)
            return -1;
        return auxiliaryColorInterceptor.getAuxiliaryColor();
    }

    public void setRoundRectSupport(RoundRectSupport roundRectSupport) {
        this.roundRectSupport = roundRectSupport;
    }

    public RoundRectSupport getRoundRectSupport() {
        return roundRectSupport;
    }

    public void setLeftTop(float r) {
        if (roundRectSupport == null)
            return;
        roundRectSupport.setLeftTop(r);
    }

    public void setRightTop(float r) {
        if (roundRectSupport == null)
            return;
        roundRectSupport.setRightTop(r);
    }

    public void setLeftBottom(float r) {
        if (roundRectSupport == null)
            return;
        roundRectSupport.setLeftBottom(r);
    }

    public void setRightBottom(float r) {
        if (roundRectSupport == null)
            return;
        roundRectSupport.setRightBottom(r);
    }

    public float getLeftTop() {
        if (roundRectSupport == null)
            return -1f;
        return roundRectSupport.getLeftTop();
    }

    public float getRightTop() {
        if (roundRectSupport == null)
            return -1f;
        return roundRectSupport.getRightTop();
    }

    public float getLeftBottom() {
        if (roundRectSupport == null)
            return -1f;
        return roundRectSupport.getLeftBottom();
    }

    public float getRightBottom() {
        if (roundRectSupport == null)
            return -1f;
        return roundRectSupport.getRightBottom();
    }
}
