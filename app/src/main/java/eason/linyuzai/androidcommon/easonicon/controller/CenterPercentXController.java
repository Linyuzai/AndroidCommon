package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class CenterPercentXController extends AbsController {

    public CenterPercentXController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Center Percent X:";
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
        return true;
    }

    @Override
    public void onUpdate(int progress) {
        float val = progress / 100f;
        setValue(String.valueOf(val));
        painter().setCenterPercentX(val);
        /*if (icon().getType() != EasonIcon.Type.NONE) {
            icon().setType(icon().getType(), true);
        }*/
        icon().update();
    }
}
