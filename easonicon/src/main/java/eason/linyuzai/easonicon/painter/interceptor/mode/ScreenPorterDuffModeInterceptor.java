package eason.linyuzai.easonicon.painter.interceptor.mode;

import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class ScreenPorterDuffModeInterceptor extends PorterDuffModeInterceptor {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScreenPorterDuffModeInterceptor() {
        super(PorterDuff.Mode.SCREEN);
    }
}
