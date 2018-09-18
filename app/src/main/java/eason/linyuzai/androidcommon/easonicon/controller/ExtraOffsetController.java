package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.annotation.ExtraOffsetField;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class ExtraOffsetController extends AbsController {

    public ExtraOffsetController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Extra Offset:";
    }

    @Override
    public int getMaxProgress() {
        return 200;
    }

    @Override
    public int getInitProgress() {
        return 96;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {

    }

    @Override
    public boolean ifVisible(Painter painter) {
        return painter.getClass().getAnnotation(ExtraOffsetField.class) != null;
    }

    @Override
    public int getProgressFromValue(String value) {
        return Integer.valueOf(value) + 100;
    }

    @Override
    public void onUpdate(int progress) {
        int val = progress - 100;
        setValue(String.valueOf(val));
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter.isSupportExtraOffset())
                painter.toExtraOffsetSupport().setExtraOffset(eason().dip(val));
        });
        //icon().setExtraOffset(eason().dip(val));
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}
