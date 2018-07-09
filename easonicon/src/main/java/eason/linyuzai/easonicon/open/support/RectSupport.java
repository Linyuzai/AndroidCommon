package eason.linyuzai.easonicon.open.support;

public interface RectSupport {
    /**
     * 设置xy百分比，并居中
     *
     * @param centerPercent 百分比
     */
    default void setCenterPercent(float centerPercent) {
        setCenterPercentX(centerPercent);
        setCenterPercentY(centerPercent);
    }

    default void setCenterPercentX(float centerPercentX) {
        setPercentX(centerPercentX);
        setOffsetPercentX((1f - centerPercentX) * 0.5f);
        setOffsetX(0f);
    }

    default void setCenterPercentY(float centerPercentY) {
        setPercentY(centerPercentY);
        setOffsetPercentY((1f - centerPercentY) * 0.5f);
        setOffsetY(0f);
    }

    /**
     * 设置xy百分比
     *
     * @param percent 百分比
     */
    default void setPercent(float percent) {
        setPercentX(percent);
        setPercentY(percent);
    }

    /**
     * 设置xy偏移量
     *
     * @param offset 偏移量
     */
    default void setOffset(float offset) {
        setOffsetX(offset);
        setOffsetY(offset);
    }

    /**
     * 设置xy偏移百分比
     *
     * @param offsetPercent 百分比
     */
    default void setOffsetPercent(float offsetPercent) {
        setOffsetPercentX(offsetPercent);
        setOffsetPercentY(offsetPercent);
    }

    /**
     * 设置x百分比
     *
     * @param percentX x百分比
     */
    void setPercentX(float percentX);

    /**
     * 获得x百分比
     *
     * @return x百分比
     */
    float getPercentX();

    /**
     * 设置y百分比
     *
     * @param percentY y百分比
     */
    void setPercentY(float percentY);

    /**
     * 获得y百分比
     *
     * @return y百分比
     */
    float getPercentY();

    /**
     * 设置x偏移量
     *
     * @param offsetX x偏移量
     */
    void setOffsetX(float offsetX);

    /**
     * 获得x偏移量
     *
     * @return x偏移量
     */
    float getOffsetX();

    /**
     * 设置y偏移量
     *
     * @param offsetY y偏移量
     */
    void setOffsetY(float offsetY);

    /**
     * 获得y偏移量
     *
     * @return y偏移量
     */
    float getOffsetY();

    /**
     * 设置x偏移量百分比
     *
     * @param offsetPercentX x偏移量百分比
     */
    void setOffsetPercentX(float offsetPercentX);

    /**
     * 获得x偏移量百分比
     *
     * @return x偏移量百分比
     */
    float getOffsetPercentX();

    /**
     * 设置y偏移量百分比
     *
     * @param offsetPercentY y偏移量百分比
     */
    void setOffsetPercentY(float offsetPercentY);

    /**
     * 获得y偏移量百分比
     *
     * @return y偏移量百分比
     */
    float getOffsetPercentY();
}
