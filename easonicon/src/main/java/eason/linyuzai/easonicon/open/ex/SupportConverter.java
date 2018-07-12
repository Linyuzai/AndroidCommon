package eason.linyuzai.easonicon.open.ex;

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
    default boolean isSupportArc() {
        return (this instanceof ArcSupport);
    }

    default ArcSupport toArcSupport() {
        return (ArcSupport) this;
    }

    default boolean isSupportAuxiliaryScale() {
        return (this instanceof AuxiliaryScaleSupport);
    }

    default AuxiliaryScaleSupport toAuxiliaryScaleSupport() {
        return (AuxiliaryScaleSupport) this;
    }

    default boolean isSupportAuxiliaryColor() {
        return (this instanceof AuxiliaryColorSupport);
    }

    default AuxiliaryColorSupport toAuxiliaryColorSupport() {
        return (AuxiliaryColorSupport) this;
    }

    default boolean isSupportBitmap() {
        return (this instanceof BitmapSupport);
    }

    default BitmapSupport toBitmapSupport() {
        return (BitmapSupport) this;
    }

    default boolean isSupportEdgeCount() {
        return (this instanceof EdgeCountSupport);
    }

    default EdgeCountSupport toEdgeCountSupport() {
        return (EdgeCountSupport) this;
    }

    default boolean isSupportExtraOffset() {
        return (this instanceof ExtraOffsetSupport);
    }

    default ExtraOffsetSupport toExtraOffsetSupport() {
        return (ExtraOffsetSupport) this;
    }

    default boolean isSupportPenSizeScale() {
        return (this instanceof PenSizeScaleSupport);
    }

    default PenSizeScaleSupport toPenSizeScaleSupport() {
        return (PenSizeScaleSupport) this;
    }

    default boolean isSupportRoundRect() {
        return (this instanceof RoundRectSupport);
    }

    default RoundRectSupport toRoundRectSupport() {
        return (RoundRectSupport) this;
    }

    default boolean isSupportText() {
        return (this instanceof TextSupport);
    }

    default TextSupport toTextSupport() {
        return (TextSupport) this;
    }
}
