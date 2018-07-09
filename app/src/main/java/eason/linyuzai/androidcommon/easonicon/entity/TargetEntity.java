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
    private int offsetPercentX = 0;
    private int offsetPercentY = 0;

    public static void setIcon(EasonIcon icon) {
        TargetEntity.icon = icon;
    }

    public TargetEntity(int type) {
        targetName = EasonIcon.getType(type).getPainterClass().getSimpleName();
        icon.setType(type);
        painter = icon.getPainter(0);
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
}
