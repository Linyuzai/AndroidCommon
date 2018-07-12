package eason.linyuzai.easonicon.painter;

import android.graphics.Bitmap;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.support.ArcSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.BitmapSupport;
import eason.linyuzai.easonicon.open.support.EdgeCountSupport;
import eason.linyuzai.easonicon.open.support.ExtraOffsetSupport;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.open.support.TextSupport;

public class SupportEasonPainterSet extends EasonPainterSet {

    public static final float NOT_SUPPORT_FLOAT = Float.NaN;
    public static final int NOT_SUPPORT_INT = -1;

    private ArcSupport arcSupport;
    private Painter auxiliaryScalePainter;
    private AuxiliaryColorSupport auxiliaryColorSupport;
    private BitmapSupport bitmapSupport;
    private EdgeCountSupport edgeCountSupport;
    private ExtraOffsetSupport extraOffsetSupport;
    private PenSizeScaleSupport penSizeScaleSupport;
    private RoundRectSupport roundRectSupport;
    private TextSupport textSupport;

    @Override
    public void addPainter(Painter painter) {
        if (painter.isSupportArc())
            setArcSupport(painter.toArcSupport());
        if (painter.isSupportBitmap())
            setBitmapSupport(painter.toBitmapSupport());
        if (painter.isSupportEdgeCount())
            setEdgeCountSupport(painter.toEdgeCountSupport());
        if (painter.isSupportExtraOffset())
            setExtraOffsetSupport(painter.toExtraOffsetSupport());
        if (painter.isSupportRoundRect())
            setRoundRectSupport(painter.toRoundRectSupport());
        if (painter.isSupportText())
            setTextSupport(painter.toTextSupport());
        super.addPainter(painter);
    }

    @Override
    public void addPainter(int index, Painter painter) {
        if (painter.isSupportArc())
            setArcSupport(painter.toArcSupport());
        if (painter.isSupportBitmap())
            setBitmapSupport(painter.toBitmapSupport());
        if (painter.isSupportEdgeCount())
            setEdgeCountSupport(painter.toEdgeCountSupport());
        if (painter.isSupportExtraOffset())
            setExtraOffsetSupport(painter.toExtraOffsetSupport());
        if (painter.isSupportRoundRect())
            setRoundRectSupport(painter.toRoundRectSupport());
        if (painter.isSupportText())
            setTextSupport(painter.toTextSupport());
        super.addPainter(index, painter);
    }

    @Override
    public void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor.isSupportAuxiliaryColor())
            setAuxiliaryColorSupport(interceptor.toAuxiliaryColorSupport());
        if (interceptor.isSupportPenSizeScale())
            setPenSizeScaleSupport(interceptor.toPenSizeScaleSupport());
        super.addInterceptor(interceptor, recursiveSet);
    }

    @Override
    public void addInterceptor(int index, PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor.isSupportAuxiliaryColor())
            setAuxiliaryColorSupport(interceptor.toAuxiliaryColorSupport());
        if (interceptor.isSupportPenSizeScale())
            setPenSizeScaleSupport(interceptor.toPenSizeScaleSupport());
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

    public AuxiliaryColorSupport getAuxiliaryColorSupport() {
        return auxiliaryColorSupport;
    }

    public void setAuxiliaryColorSupport(AuxiliaryColorSupport auxiliaryColorSupport) {
        this.auxiliaryColorSupport = auxiliaryColorSupport;
    }

    public int getAuxiliaryColor() {
        if (isSupportAuxiliaryColor())
            return auxiliaryColorSupport.getAuxiliaryColor();
        return NOT_SUPPORT_INT;
    }

    public void setAuxiliaryColor(int color) {
        if (isSupportAuxiliaryColor())
            auxiliaryColorSupport.setAuxiliaryColor(color);
    }

    //-------auxiliaryColor---------//
    //-------bitmap---------//

    public BitmapSupport getBitmapSupport() {
        return bitmapSupport;
    }

    public void setBitmapSupport(BitmapSupport bitmapSupport) {
        this.bitmapSupport = bitmapSupport;
    }

    public Bitmap getBitmap() {
        if (isSupportBitmap())
            return bitmapSupport.getBitmap();
        return null;
    }

    public void setBitmap(Bitmap bitmap) {
        if (isSupportBitmap())
            bitmapSupport.setBitmap(bitmap);
    }

    //-------bitmap---------//
    //-------edgeCount---------//

    public EdgeCountSupport getEdgeCountSupport() {
        return edgeCountSupport;
    }

    public void setEdgeCountSupport(EdgeCountSupport edgeCountSupport) {
        this.edgeCountSupport = edgeCountSupport;
    }

    public int getEdgeCount() {
        if (isSupportEdgeCount())
            return edgeCountSupport.getEdgeCount();
        return NOT_SUPPORT_INT;
    }

    public void setEdgeCount(int edgeCount) {
        if (isSupportEdgeCount())
            edgeCountSupport.setEdgeCount(edgeCount);
    }

    //-------edgeCount---------//
    //-------extraOffset---------//

    public ExtraOffsetSupport getExtraOffsetSupport() {
        return extraOffsetSupport;
    }

    public void setExtraOffsetSupport(ExtraOffsetSupport extraOffsetSupport) {
        this.extraOffsetSupport = extraOffsetSupport;
    }

    public float getExtraOffset() {
        if (isSupportExtraOffset())
            return extraOffsetSupport.getExtraOffset();
        return NOT_SUPPORT_FLOAT;
    }

    public void setExtraOffset(float extraOffset) {
        if (isSupportExtraOffset())
            extraOffsetSupport.setExtraOffset(extraOffset);
    }

    //-------extraOffset---------//
    //-------penSizeScale---------//

    public PenSizeScaleSupport getPenSizeScaleSupport() {
        return penSizeScaleSupport;
    }

    public void setPenSizeScaleSupport(PenSizeScaleSupport penSizeScaleSupport) {
        this.penSizeScaleSupport = penSizeScaleSupport;
    }

    public float getPenSizeScale() {
        if (isSupportPenSizeScale())
            return penSizeScaleSupport.getPenSizeScale();
        return NOT_SUPPORT_FLOAT;
    }

    public void setPenSizeScale(float penSizeScale) {
        if (isSupportPenSizeScale())
            penSizeScaleSupport.setPenSizeScale(penSizeScale);
    }

    //-------penSizeScale---------//
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
    //-------text---------//

    public TextSupport getTextSupport() {
        return textSupport;
    }

    public void setTextSupport(TextSupport textSupport) {
        this.textSupport = textSupport;
    }

    public String getText() {
        if (isSupportText())
            return textSupport.getText();
        return null;
    }

    public void setText(String text) {
        if (isSupportText())
            textSupport.setText(text);
    }
    //-------text---------//
}
