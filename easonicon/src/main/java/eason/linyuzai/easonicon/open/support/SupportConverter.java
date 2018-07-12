package eason.linyuzai.easonicon.open.support;

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
}
