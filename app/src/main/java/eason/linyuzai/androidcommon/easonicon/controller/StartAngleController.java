package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class StartAngleController extends AbsController {

    public StartAngleController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Start Angle:";
    }

    @Override
    public int getMaxProgress() {
        return 720;
    }

    @Override
    public int getInitProgress() {
        return 360;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {
    }

    @Override
    public boolean ifVisible(Painter painter) {
        return painter.getClass().getAnnotation(ArcField.class) != null;
    }

    @Override
    public void onUpdate(int progress) {
        int val = progress - 360;
        setValue(String.valueOf(val));
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter.isSupportArc())
                painter.toArcSupport().setStartAngle(val);
        });
        //icon().setStartAngle(val);
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}
