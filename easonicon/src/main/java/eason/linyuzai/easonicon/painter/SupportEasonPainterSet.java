package eason.linyuzai.easonicon.painter;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

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

    private Painter auxiliaryScalePainter;
    private AuxiliaryColorSupport auxiliaryColorSupport;
    private PenSizeScaleSupport penSizeScaleSupport;
    private List<ArcSupport> arcSupports = new ArrayList<>();
    private List<BitmapSupport> bitmapSupports = new ArrayList<>();
    private List<EdgeCountSupport> edgeCountSupports = new ArrayList<>();
    private List<ExtraOffsetSupport> extraOffsetSupports = new ArrayList<>();
    private List<RoundRectSupport> roundRectSupports = new ArrayList<>();
    private List<TextSupport> textSupports = new ArrayList<>();

    @Override
    public void addPainter(Painter painter) {
        addPainter(painter, true);
    }

    public void addPainter(Painter painter, boolean isSupport) {
        if (isSupport) {
            if (painter.isSupportArc())
                addArcSupport(painter.toArcSupport());
            if (painter.isSupportBitmap())
                addBitmapSupport(painter.toBitmapSupport());
            if (painter.isSupportEdgeCount())
                addEdgeCountSupport(painter.toEdgeCountSupport());
            if (painter.isSupportExtraOffset())
                addExtraOffsetSupport(painter.toExtraOffsetSupport());
            if (painter.isSupportRoundRect())
                addRoundRectSupport(painter.toRoundRectSupport());
            if (painter.isSupportText())
                addTextSupport(painter.toTextSupport());
        }
        super.addPainter(painter);
    }

    @Override
    public void addPainter(int index, Painter painter) {
        addPainter(index, painter, true);
    }

    public void addPainter(int index, Painter painter, boolean isSupport) {
        if (isSupport) {
            if (painter.isSupportArc())
                addArcSupport(painter.toArcSupport());
            if (painter.isSupportBitmap())
                addBitmapSupport(painter.toBitmapSupport());
            if (painter.isSupportEdgeCount())
                addEdgeCountSupport(painter.toEdgeCountSupport());
            if (painter.isSupportExtraOffset())
                addExtraOffsetSupport(painter.toExtraOffsetSupport());
            if (painter.isSupportRoundRect())
                addRoundRectSupport(painter.toRoundRectSupport());
            if (painter.isSupportText())
                addTextSupport(painter.toTextSupport());
        }
        super.addPainter(index, painter);
    }

    @Override
    public void removePainter(int index) {
        Painter painter = getPainter(index);
        if (null == painter)
            return;
        removePainter(painter);
    }

    @Override
    public void removePainter(Painter painter) {
        if (painter.isSupportArc())
            removeArcSupport(painter.toArcSupport());
        if (painter.isSupportBitmap())
            removeBitmapSupport(painter.toBitmapSupport());
        if (painter.isSupportEdgeCount())
            removeEdgeCountSupport(painter.toEdgeCountSupport());
        if (painter.isSupportExtraOffset())
            removeExtraOffsetSupport(painter.toExtraOffsetSupport());
        if (painter.isSupportRoundRect())
            removeRoundRectSupport(painter.toRoundRectSupport());
        if (painter.isSupportText())
            removeTextSupport(painter.toTextSupport());
        super.removePainter(painter);
    }

    @Override
    public void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor.isSupportAuxiliaryColor()) {
            setAuxiliaryColorSupport(interceptor.toAuxiliaryColorSupport());
        }
        if (interceptor.isSupportPenSizeScale()) {
            setPenSizeScaleSupport(interceptor.toPenSizeScaleSupport());
        }
        super.addInterceptor(interceptor, recursiveSet);
    }

    @Override
    public void removeInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        if (interceptor.isSupportAuxiliaryColor()) {
            setAuxiliaryColorSupport(null);
        }
        if (interceptor.isSupportPenSizeScale()) {
            setPenSizeScaleSupport(null);
        }
        super.removeInterceptor(interceptor, recursiveSet);
    }

    //-------arc---------//

    public List<ArcSupport> getArcSupports() {
        return arcSupports;
    }

    public void addArcSupport(ArcSupport arcSupport) {
        this.arcSupports.add(arcSupport);
    }

    public void removeArcSupport(ArcSupport arcSupport) {
        this.arcSupports.remove(arcSupport);
    }

    public float getStartAngle() {
        if (isSupportArc() && arcSupports.size() > 0) {
            return arcSupports.get(0).getStartAngle();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setStartAngle(float startAngle) {
        if (isSupportArc()) {
            for (ArcSupport arcSupport : arcSupports) {
                arcSupport.setStartAngle(startAngle);
            }
        }
    }

    public float getSweepAngle() {
        if (isSupportArc() && arcSupports.size() > 0) {
            return arcSupports.get(0).getSweepAngle();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setSweepAngle(float sweepAngle) {
        if (isSupportArc()) {
            for (ArcSupport arcSupport : arcSupports) {
                arcSupport.setSweepAngle(sweepAngle);
            }
        }
    }

    public boolean isUseCenter() {
        return isSupportArc() && arcSupports.size() > 0 && arcSupports.get(0).isUseCenter();
    }

    public void setUseCenter(boolean useCenter) {
        if (isSupportArc()) {
            for (ArcSupport arcSupport : arcSupports) {
                arcSupport.setUseCenter(useCenter);
            }
        }
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
        if (isSupportAuxiliaryScale() && null != auxiliaryScalePainter &&
                auxiliaryScalePainter.getPercentX() == auxiliaryScalePainter.getPercentY() &&
                auxiliaryScalePainter.getOffsetPercentX() == auxiliaryScalePainter.getOffsetPercentY() &&
                auxiliaryScalePainter.getOffsetX() == 0f && auxiliaryScalePainter.getOffsetY() == 0f) {
            return auxiliaryScalePainter.getPercentX();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setAuxiliaryScale(float scale) {
        if (isSupportAuxiliaryScale()) {
            auxiliaryScalePainter.setCenterPercent(scale);
        }
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
        if (isSupportAuxiliaryColor() && null != auxiliaryColorSupport) {
            return auxiliaryColorSupport.getAuxiliaryColor();
        }
        return NOT_SUPPORT_INT;
    }

    public void setAuxiliaryColor(int color) {
        if (isSupportAuxiliaryColor() && null != auxiliaryColorSupport) {
            auxiliaryColorSupport.setAuxiliaryColor(color);
        }
    }

    //-------auxiliaryColor---------//
    //-------bitmap---------//

    public List<BitmapSupport> getBitmapSupports() {
        return bitmapSupports;
    }

    public void addBitmapSupport(BitmapSupport bitmapSupport) {
        this.bitmapSupports.add(bitmapSupport);
    }

    public void removeBitmapSupport(BitmapSupport bitmapSupport) {
        this.bitmapSupports.remove(bitmapSupport);
    }

    public Bitmap getBitmap() {
        if (isSupportBitmap() && bitmapSupports.size() > 0) {
            return bitmapSupports.get(0).getBitmap();
        }
        return null;
    }

    public void setBitmap(Bitmap bitmap) {
        if (isSupportBitmap()) {
            for (BitmapSupport bitmapSupport : bitmapSupports) {
                bitmapSupport.setBitmap(bitmap);
            }
        }
    }

    //-------bitmap---------//
    //-------edgeCount---------//

    public List<EdgeCountSupport> getEdgeCountSupports() {
        return edgeCountSupports;
    }

    public void addEdgeCountSupport(EdgeCountSupport edgeCountSupport) {
        this.edgeCountSupports.add(edgeCountSupport);
    }

    public void removeEdgeCountSupport(EdgeCountSupport edgeCountSupport) {
        this.edgeCountSupports.remove(edgeCountSupport);
    }

    public int getEdgeCount() {
        if (isSupportEdgeCount() && edgeCountSupports.size() > 0) {
            return edgeCountSupports.get(0).getEdgeCount();
        }
        return NOT_SUPPORT_INT;
    }

    public void setEdgeCount(int edgeCount) {
        if (isSupportEdgeCount()) {
            for (EdgeCountSupport edgeCountSupport : edgeCountSupports) {
                edgeCountSupport.setEdgeCount(edgeCount);
            }
        }
    }

    //-------edgeCount---------//
    //-------extraOffset---------//

    public List<ExtraOffsetSupport> getExtraOffsetSupports() {
        return extraOffsetSupports;
    }

    public void addExtraOffsetSupport(ExtraOffsetSupport extraOffsetSupport) {
        this.extraOffsetSupports.add(extraOffsetSupport);
    }

    public void removeExtraOffsetSupport(ExtraOffsetSupport extraOffsetSupport) {
        this.extraOffsetSupports.remove(extraOffsetSupport);
    }

    public float getExtraOffset() {
        if (isSupportExtraOffset() && extraOffsetSupports.size() > 0) {
            return extraOffsetSupports.get(0).getExtraOffset();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setExtraOffset(float extraOffset) {
        if (isSupportExtraOffset()) {
            for (ExtraOffsetSupport extraOffsetSupport : extraOffsetSupports) {
                extraOffsetSupport.setExtraOffset(extraOffset);
            }
        }
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
        if (isSupportPenSizeScale() && null != penSizeScaleSupport) {
            return penSizeScaleSupport.getPenSizeScale();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setPenSizeScale(float penSizeScale) {
        if (isSupportPenSizeScale() && null != penSizeScaleSupport) {
            penSizeScaleSupport.setPenSizeScale(penSizeScale);
        }
    }

    //-------penSizeScale---------//
    //-------roundRect---------//

    public List<RoundRectSupport> getRoundRectSupports() {
        return roundRectSupports;
    }


    public void addRoundRectSupport(RoundRectSupport roundRectSupport) {
        this.roundRectSupports.add(roundRectSupport);
    }

    public void removeRoundRectSupport(RoundRectSupport roundRectSupport) {
        this.roundRectSupports.remove(roundRectSupport);
    }

    public float getLeftTop() {
        if (isSupportRoundRect() && roundRectSupports.size() > 0) {
            return roundRectSupports.get(0).getLeftTop();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setLeftTop(float r) {
        if (isSupportRoundRect()) {
            for (RoundRectSupport roundRectSupport : roundRectSupports) {
                roundRectSupport.setLeftTop(r);
            }
        }
    }

    public float getRightTop() {
        if (isSupportRoundRect() && roundRectSupports.size() > 0) {
            return roundRectSupports.get(0).getRightTop();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setRightTop(float r) {
        if (isSupportRoundRect()) {
            for (RoundRectSupport roundRectSupport : roundRectSupports) {
                roundRectSupport.setRightTop(r);
            }
        }
    }

    public float getLeftBottom() {
        if (isSupportRoundRect() && roundRectSupports.size() > 0) {
            return roundRectSupports.get(0).getLeftBottom();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setLeftBottom(float r) {
        if (isSupportRoundRect()) {
            for (RoundRectSupport roundRectSupport : roundRectSupports) {
                roundRectSupport.setLeftBottom(r);
            }
        }
    }

    public float getRightBottom() {
        if (isSupportRoundRect() && roundRectSupports.size() > 0) {
            return roundRectSupports.get(0).getRightBottom();
        }
        return NOT_SUPPORT_FLOAT;
    }

    public void setRightBottom(float r) {
        if (isSupportRoundRect()) {
            for (RoundRectSupport roundRectSupport : roundRectSupports) {
                roundRectSupport.setRightBottom(r);
            }
        }
    }

    //-------roundRect---------//
    //-------text---------//

    public List<TextSupport> getTextSupports() {
        return textSupports;
    }

    public void addTextSupport(TextSupport textSupport) {
        this.textSupports.add(textSupport);
    }

    public void removeTextSupport(TextSupport textSupport) {
        this.textSupports.remove(textSupport);
    }

    public String getText() {
        if (isSupportText() && textSupports.size() > 0) {
            return textSupports.get(0).getText();
        }
        return null;
    }

    public void setText(String text) {
        if (isSupportText()) {
            for (TextSupport textSupport : textSupports) {
                textSupport.setText(text);
            }
        }
    }
    //-------text---------//
}
