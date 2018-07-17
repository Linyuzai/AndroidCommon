package eason.linyuzai.easonicon.open.ex;

import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.open.support.ArcSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryColorSupport;
import eason.linyuzai.easonicon.open.support.AuxiliaryScaleSupport;
import eason.linyuzai.easonicon.open.support.BitmapSupport;
import eason.linyuzai.easonicon.open.support.EdgeCountSupport;
import eason.linyuzai.easonicon.open.support.ExtraOffsetSupport;
import eason.linyuzai.easonicon.open.support.PenSizeScaleSupport;
import eason.linyuzai.easonicon.open.support.RoundRectSupport;
import eason.linyuzai.easonicon.open.support.TextSupport;

public interface SupportConverter {

    default boolean isPainterSet() {
        return (this instanceof PainterSet);
    }

    default PainterSet toPainterSet() {
        return (PainterSet) this;
    }

    default PainterSet toPainterSetUnforced() {
        if (isPainterSet())
            return toPainterSet();
        return null;
    }

    default boolean isSupportArc() {
        return (this instanceof ArcSupport);
    }

    default ArcSupport toArcSupport() {
        return (ArcSupport) this;
    }

    default ArcSupport toArcSupportUnforced() {
        if (isSupportArc())
            return toArcSupport();
        return null;
    }

    default boolean isSupportAuxiliaryScale() {
        return (this instanceof AuxiliaryScaleSupport);
    }

    default AuxiliaryScaleSupport toAuxiliaryScaleSupport() {
        return (AuxiliaryScaleSupport) this;
    }

    default AuxiliaryScaleSupport toAuxiliaryScaleSupportUnforced() {
        if (isSupportAuxiliaryScale())
            return toAuxiliaryScaleSupport();
        return null;
    }

    default boolean isSupportAuxiliaryColor() {
        return (this instanceof AuxiliaryColorSupport);
    }

    default AuxiliaryColorSupport toAuxiliaryColorSupport() {
        return (AuxiliaryColorSupport) this;
    }

    default AuxiliaryColorSupport toAuxiliaryColorSupportUnforced() {
        if (isSupportAuxiliaryColor())
            return toAuxiliaryColorSupport();
        return null;
    }

    default boolean isSupportBitmap() {
        return (this instanceof BitmapSupport);
    }

    default BitmapSupport toBitmapSupport() {
        return (BitmapSupport) this;
    }

    default BitmapSupport toBitmapSupportUnforced() {
        if (isSupportBitmap())
            return toBitmapSupport();
        return null;
    }

    default boolean isSupportEdgeCount() {
        return (this instanceof EdgeCountSupport);
    }

    default EdgeCountSupport toEdgeCountSupport() {
        return (EdgeCountSupport) this;
    }

    default EdgeCountSupport toEdgeCountSupportUnforced() {
        if (isSupportEdgeCount())
            return toEdgeCountSupport();
        return null;
    }

    default boolean isSupportExtraOffset() {
        return (this instanceof ExtraOffsetSupport);
    }

    default ExtraOffsetSupport toExtraOffsetSupport() {
        return (ExtraOffsetSupport) this;
    }

    default ExtraOffsetSupport toExtraOffsetSupportUnforced() {
        if (isSupportExtraOffset())
            return toExtraOffsetSupport();
        return null;
    }

    default boolean isSupportPenSizeScale() {
        return (this instanceof PenSizeScaleSupport);
    }

    default PenSizeScaleSupport toPenSizeScaleSupport() {
        return (PenSizeScaleSupport) this;
    }

    default PenSizeScaleSupport toPenSizeScaleSupportUnforced() {
        if (isSupportPenSizeScale())
            return toPenSizeScaleSupport();
        return null;
    }

    default boolean isSupportRoundRect() {
        return (this instanceof RoundRectSupport);
    }

    default RoundRectSupport toRoundRectSupport() {
        return (RoundRectSupport) this;
    }

    default RoundRectSupport toRoundRectSupportUnforced() {
        if (isSupportRoundRect())
            return toRoundRectSupport();
        return null;
    }

    default boolean isSupportText() {
        return (this instanceof TextSupport);
    }

    default TextSupport toTextSupport() {
        return (TextSupport) this;
    }

    default TextSupport toTextSupportUnforced() {
        if (isSupportText())
            return toTextSupport();
        return null;
    }
}
