package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class PenSizeScaleController extends AbsController {

    public PenSizeScaleController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Pen Size Scale:";
    }

    @Override
    public int getMaxProgress() {
        return 200;
    }

    @Override
    public int getInitProgress() {
        return 100;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {

    }

    @Override
    public boolean ifVisible(Painter painter) {
        return painter.getClass().getAnnotation(PenSizeScaleField.class) != null;
    }

    @Override
    public void onUpdate(int progress) {
        float val = progress / 100f;
        setValue(String.valueOf(val));
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter.isSupportPenSizeScale())
                painter.toPenSizeScaleSupport().setPenSizeScale(val);
        });
        //icon().setPenSizeScale(val);
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}
