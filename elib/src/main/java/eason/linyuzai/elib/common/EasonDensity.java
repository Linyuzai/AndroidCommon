package eason.linyuzai.elib.common;

import android.content.Context;

public class EasonDensity {
    private static float density = 0;
    private static int width = 0;
    private static int height = 0;

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        if (density == 0) {
            getDensity(context);
        }
        return (int) (dpValue * density + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        if (density == 0) {
            getDensity(context);
        }
        return (int) (pxValue / density + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        if (width == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels;
        }
        return width;
    }

    public static int getScreenHeight(Context context) {
        if (height == 0) {
            height = context.getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }

    public static float getDensity(Context context) {
        if (density == 0) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }
}
