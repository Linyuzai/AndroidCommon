package eason.linyuzai.androidcommon.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import eason.linyuzai.androidcommon.R;
import eason.linyuzai.elib.component.EasonActivity;

public class ScrollPanelActivity extends EasonActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_panel);
    }
}
