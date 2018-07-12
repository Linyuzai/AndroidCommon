package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;

@SuppressLint("ViewConstructor")
public class RightBottomController extends AbsController {

    public RightBottomController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Right Bottom:";
    }

    @Override
    public int getMaxProgress() {
        return 100;
    }

    @Override
    public int getInitProgress() {
        return 4;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {
        seekBar.setProgress(entity.getRightBottom());
    }

    @Override
    public void onUpdate(int progress) {
        int val = progress;
        setValue(String.valueOf(val));
        if (entity() != null)
            entity().setRightBottom(progress);
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter instanceof SupportEasonPainterSet && painter.isSupportRoundRect())
                painter.toRoundRectSupport().setRightBottom(eason().dip(val));
        });
        //icon.setRightBottomRound(eason.dip(val));
        //icon.setType(icon.getType(), true);
        icon().update();
    }
}
