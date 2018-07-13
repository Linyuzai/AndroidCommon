package eason.linyuzai.androidcommon.easonicon.entity;

import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;

public class TargetEntity {
    private static EasonIcon icon;

    private String targetName;
    private Painter painter;
    private boolean isSelect;

    private int percentX = 100;
    private int percentY = 100;
    private int offsetPercentX = 100;
    private int offsetPercentY = 100;

    private int leftTop = 4;
    private int leftBottom = 4;
    private int rightTop = 4;
    private int rightBottom = 4;

    public static void setIcon(EasonIcon icon) {
        TargetEntity.icon = icon;
    }

    public TargetEntity(int type) {
        targetName = EasonIcon.getType(type).getPainterClass().getSimpleName();
        icon.setType(type, true);
        painter = icon.getPainter(0);
        isSelect = true;
    }

    public TargetEntity(EasonIcon icon) {
        targetName = "EasonIcon(the whole range)";
        painter = icon.getPainterSet();
        isSelect = true;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getPercentX() {
        return percentX;
    }

    public void setPercentX(int percentX) {
        this.percentX = percentX;
    }

    public int getPercentY() {
        return percentY;
    }

    public void setPercentY(int percentY) {
        this.percentY = percentY;
    }

    public int getOffsetPercentX() {
        return offsetPercentX;
    }

    public void setOffsetPercentX(int offsetPercentX) {
        this.offsetPercentX = offsetPercentX;
    }

    public int getOffsetPercentY() {
        return offsetPercentY;
    }

    public void setOffsetPercentY(int offsetPercentY) {
        this.offsetPercentY = offsetPercentY;
    }

    public int getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(int leftTop) {
        this.leftTop = leftTop;
    }

    public int getLeftBottom() {
        return leftBottom;
    }

    public void setLeftBottom(int leftBottom) {
        this.leftBottom = leftBottom;
    }

    public int getRightTop() {
        return rightTop;
    }

    public void setRightTop(int rightTop) {
        this.rightTop = rightTop;
    }

    public int getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(int rightBottom) {
        this.rightBottom = rightBottom;
    }
}
