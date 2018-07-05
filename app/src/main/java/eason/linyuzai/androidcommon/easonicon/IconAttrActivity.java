package eason.linyuzai.androidcommon.easonicon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import java.util.List;

import eason.linyuzai.androidcommon.LibraryHelper;
import eason.linyuzai.androidcommon.R;
import eason.linyuzai.androidcommon.easonicon.controller.CenterPercentController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentYController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetXController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetYController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentYController;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.elib.component.EasonActivity;

public class IconAttrActivity extends EasonActivity {

    private LibraryHelper.LibraryParam param;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param = getLibraryParam().get(0);
        setStatusBarColor(param.getTitleColor());
        setContentView(R.layout.activity_icon_attrs);
        id(R.id.back).setOnClickListener(v -> finish());
        id(R.id.title).setBackgroundColor(param.getTitleColor());
        EasonIcon icon = id(R.id.ei);
        icon.setPenSize(dip(3));
        icon.setColor(param.getContentColor());
        icon.setEdgeCount(3);
        icon.setExtraOffset(-dip(4));
        icon.setSweepAngle(120f);
        icon.setLeftTopRound(dip(5));
        icon.setLeftBottomRound(dip(5));
        icon.setRightTopRound(dip(5));
        icon.setRightBottomRound(dip(5));
        icon.getPaint().setTextSize(dip(15));
        icon.getPainterSet().setCenterPercent(0.9f);
        icon.setType(getIntent().getIntExtra("type", 0));
        ViewGroup group = id(R.id.op);
        group.addView(new CenterPercentController(this, icon));
        group.addView(new PercentController(this, icon));
        group.addView(new PercentXController(this, icon));
        group.addView(new PercentYController(this, icon));
        group.addView(new OffsetPercentController(this, icon));
        group.addView(new OffsetPercentXController(this, icon));
        group.addView(new OffsetPercentYController(this, icon));
        group.addView(new OffsetXController(this, icon));
        group.addView(new OffsetYController(this, icon));
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }
}
