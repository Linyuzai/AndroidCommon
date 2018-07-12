package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;

@SuppressLint("ViewConstructor")
public class AuxiliaryScaleController extends AbsController {

    public AuxiliaryScaleController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Auxiliary Scale:";
    }

    @Override
    public int getMaxProgress() {
        return 100;
    }

    @Override
    public int getInitProgress() {
        return 50;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {

    }

    @Override
    public void onUpdate(int progress) {
        float val = progress / 100f;
        setValue(String.valueOf(val));

        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter instanceof SupportEasonPainterSet && painter.isSupportAuxiliaryScale()) {
                painter.toAuxiliaryScaleSupport().setAuxiliaryScale(val);
            }
        });
        //icon().setAuxiliaryScale(val);
        icon().update();
    }
}
