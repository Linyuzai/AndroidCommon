package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;

@SuppressLint("ViewConstructor")
public class SweepAngleController extends AbsController {

    public SweepAngleController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Sweep Angle:";
    }

    @Override
    public int getMaxProgress() {
        return 360;
    }

    @Override
    public int getInitProgress() {
        return 120;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {
    }

    @Override
    public void onUpdate(int progress) {
        float val = progress;
        setValue(String.valueOf(val));
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter instanceof SupportEasonPainterSet && painter.isSupportArc())
                painter.toArcSupport().setSweepAngle(val);
        });
        //icon().setSweepAngle(val);
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}
