package eason.linyuzai.elib.component;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Collection;

import eason.linyuzai.elib.common.EasonDensity;
import eason.linyuzai.elib.common.EasonMemory;
import eason.linyuzai.elib.common.EasonStatusBar;
import eason.linyuzai.elib.common.EasonString;
import eason.linyuzai.elib.common.EasonWidget;
import eason.linyuzai.elib.os.EasonHandler;

public abstract class EasonActivity extends AppCompatActivity {
    /**
     * 启用debug
     */
    private boolean isDebug;
    /**
     * 两次返回键退出
     */
    private TwiceBackExitState twiceBackExitState = new TwiceBackExitState();
    /**
     * 软键盘
     */
    private KeyboardState keyboardState = new KeyboardState();
    /**
     * EasonHandler
     */
    private Handler handler = new EasonHandler(this);

    /**
     * handler回调
     *
     * @param msg Message
     */
    public void handleMessage(Message msg) {

    }

    /**
     * 获得handler
     *
     * @return EasonHandler
     */
    public Handler handler() {
        return handler;
    }

    /**
     * 状态栏颜色
     *
     * @param colorRes 颜色资源
     */
    public void setStatusBarColorRes(@ColorRes int colorRes) {
        setStatusBarColor(getResources().getColor(colorRes));
    }

    /**
     * 状态栏颜色
     *
     * @param color 颜色值
     */
    public void setStatusBarColor(@ColorInt int color) {
        EasonStatusBar.setColor(this, color);
    }

    /**
     * 通过ID获得View
     *
     * @param id  控件id
     * @param <T> 控件类
     * @return View
     */
    public <T extends View> T id(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 通过ID获得View
     *
     * @param view 需要查找的控件
     * @param id   控件id
     * @param <T>  控件类
     * @return View
     */
    public <T extends View> T id(View view, @IdRes int id) {
        return view.findViewById(id);
    }

    /**
     * toast
     *
     * @param o 打印的对象
     */
    public void toast(Object o) {
        Toast.makeText(this, String.valueOf(o), Toast.LENGTH_SHORT).show();
    }

    /**
     * 开启/关闭 调试日志
     *
     * @param debug 是否开启
     */
    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * 是否开启了调试日志
     *
     * @return 是否开启了调试日志
     */
    public boolean isDebug() {
        return isDebug;
    }

    /**
     * 打印日志
     *
     * @param o 打印对象
     */
    public void log(Object o) {
        if (isDebug)
            Log.d("E-Lib", String.valueOf(o));
    }

    /**
     * 打印错误
     *
     * @param e 异常
     */
    public void error(Throwable e) {
        error(e.getMessage());
    }

    /**
     * 打印错误
     *
     * @param msg 错误信息
     */
    public void error(String msg) {
        Log.d("E-Lib", msg);
    }

    /**
     * dp转px
     *
     * @param dipValue dp值
     * @return px值
     */
    public int dip(float dipValue) {
        return EasonDensity.dip2px(this, dipValue);
    }

    /**
     * 获得Drawable
     *
     * @param drawableRes drawable资源id
     * @return drawable
     */
    public Drawable drawable(@DrawableRes int drawableRes) {
        return getResources().getDrawable(drawableRes);
    }

    public int color(@ColorRes int colorRes) {
        return getResources().getColor(colorRes);
    }

    public int statusBarHeight() {
        return EasonDensity.getStatusBarHeight(this);
    }

    public int screenWidth() {
        return EasonDensity.getScreenWidth(this);
    }

    /**
     * 屏幕高度
     *
     * @return 屏幕高度
     */
    public int screenHeight() {
        return EasonDensity.getScreenHeight(this);
    }

    public EasonMemory memory() {
        return EasonMemory.getInstance();
    }

    /**
     * 获得软键盘状态
     *
     * @return 软键盘状态
     */
    public KeyboardState getKeyboardState() {
        return keyboardState;
    }

    /**
     * 启用软键盘监听
     */
    public void enableKeyboardObserver() {
        if (keyboardState.keyboardStateChangeListener == null) {
            keyboardState.keyboardStateChangeListener = () -> {
                Rect r = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                int heightDifference = screenHeight() - (r.bottom - r.top);
                boolean isKeyboardShowing = heightDifference > screenHeight() / 3;
                if (keyboardState.isShow && !isKeyboardShowing || !keyboardState.isShow && isKeyboardShowing) {
                    keyboardState.isShow = isKeyboardShowing;
                    keyboardState.height = heightDifference;
                    onKeyboardStateChanged(keyboardState.isShow, keyboardState.height);
                }
            };
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(keyboardState.keyboardStateChangeListener);
    }

    /**
     * 禁止软键盘监听
     */
    public void disableKeyboardObserver() {
        if (keyboardState.keyboardStateChangeListener != null) {
            getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(keyboardState.keyboardStateChangeListener);
        }
    }

    /**
     * 软键盘状态改变
     *
     * @param isShow 是否显示
     * @param height 软键盘高度
     */
    public void onKeyboardStateChanged(boolean isShow, int height) {

    }

    /**
     * 隐藏软键盘
     *
     * @return 是否成功
     */
    public boolean hideSoftInput() {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // 隐藏软键盘
        if (manager == null) {
            error("hideSoftInput InputMethodManager is Null");
            return false;
        }
        return manager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    /**
     * 启用连按两次返回键退出
     */
    public void enableTwiceBackExit() {
        enableTwiceBackExit(2000);
    }

    /**
     * 启用连按两次返回键退出
     *
     * @param intervalTime 间隔时间
     */
    public void enableTwiceBackExit(long intervalTime) {
        twiceBackExitState.isTwiceBackExitEnable = true;
        twiceBackExitState.intervalTime = intervalTime;
    }

    /**
     * 禁止连按两次返回键退出
     */
    public void disableTwiceBackExit() {
        twiceBackExitState.isTwiceBackExitEnable = false;
    }

    /**
     * 连按两次返回键退出，第一次时触发
     */
    public void onFirstBackPressed() {
        toast("再按一次退出程序");
    }

    /**
     * 连按两次返回键退出时触发
     */
    public void onTwiceBackExit() {
        finish();
    }

    /**
     * join string for Collection
     *
     * @param strings Collection of string
     * @return string with join
     */
    public String stringJoin(Collection<? extends CharSequence> strings) {
        return EasonString.join(strings);
    }

    /**
     * join string for Collection
     *
     * @param strings   Collection of string
     * @param delimiter delimiter
     * @return string with join by delimiter
     */
    public String stringJoin(Collection<? extends CharSequence> strings, CharSequence delimiter) {
        return EasonString.join(strings, delimiter);
    }

    public void printViewTree(View view) {
        EasonWidget.printViewTree(view);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //连按两次返回键退出
        if (twiceBackExitState.isTwiceBackExitEnable && keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - twiceBackExitState.exitTime) > twiceBackExitState.intervalTime) {
                onFirstBackPressed();
                twiceBackExitState.exitTime = System.currentTimeMillis();
            } else {
                onTwiceBackExit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 软键盘状态
     */
    public static class KeyboardState {
        /*
        是否显示
         */
        private boolean isShow;
        /*
        高度
         */
        private int height;
        private ViewTreeObserver.OnGlobalLayoutListener keyboardStateChangeListener;

        private KeyboardState() {
            this.isShow = false;
            this.height = 0;
        }

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    /**
     * 连按两次返回键退出状态
     */
    private static class TwiceBackExitState {
        /*
        是否启用
         */
        private boolean isTwiceBackExitEnable;
        /*
        间隔时间
         */
        private long intervalTime;
        /*
        上次点击时间
         */
        private long exitTime;

        private TwiceBackExitState() {
            exitTime = 0;
        }

        public boolean isTwiceBackExitEnable() {
            return isTwiceBackExitEnable;
        }

        public void setTwiceBackExitEnable(boolean twiceBackExitEnable) {
            isTwiceBackExitEnable = twiceBackExitEnable;
        }

        public long getIntervalTime() {
            return intervalTime;
        }

        public void setIntervalTime(long intervalTime) {
            this.intervalTime = intervalTime;
        }
    }
}
