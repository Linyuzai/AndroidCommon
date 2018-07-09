package eason.linyuzai.androidcommon.easonicon.controller;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.open.Painter;

public interface AbsController {
    int TEXT_WIDTH = 117;
    int VALUE_WIDTH = 43;

    void setPainter(Painter painter);

    default void setProgress(int progress) {

    }

    default void setEntity(TargetEntity entity) {

    }
}
