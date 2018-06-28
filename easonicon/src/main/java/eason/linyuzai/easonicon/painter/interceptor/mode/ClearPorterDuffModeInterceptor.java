package eason.linyuzai.easonicon.painter.interceptor.mode;

import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class ClearPorterDuffModeInterceptor extends PorterDuffModeInterceptor {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClearPorterDuffModeInterceptor() {
        super(PorterDuff.Mode.CLEAR);
    }
}
