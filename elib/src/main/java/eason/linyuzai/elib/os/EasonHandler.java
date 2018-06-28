package eason.linyuzai.elib.os;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import eason.linyuzai.elib.component.EasonActivity;

public class EasonHandler extends Handler {
    private final WeakReference<EasonActivity> activityReference;
    private final WeakReference<eason.linyuzai.elib.component.EasonFragment> fragmentReference;
    private final WeakReference<eason.linyuzai.elib.component.v4.EasonFragment> fragmentV4Reference;

    public EasonHandler(EasonActivity activity) {
        this.activityReference = new WeakReference<>(activity);
        this.fragmentReference = new WeakReference<>(null);
        this.fragmentV4Reference = new WeakReference<>(null);
    }

    public EasonHandler(eason.linyuzai.elib.component.EasonFragment fragment) {
        this.activityReference = new WeakReference<>(null);
        this.fragmentReference = new WeakReference<>(fragment);
        this.fragmentV4Reference = new WeakReference<>(null);
    }

    public EasonHandler(eason.linyuzai.elib.component.v4.EasonFragment fragment) {
        this.activityReference = new WeakReference<>(null);
        this.fragmentReference = new WeakReference<>(null);
        this.fragmentV4Reference = new WeakReference<>(fragment);
    }

    public EasonHandler(EasonActivity activity, eason.linyuzai.elib.component.EasonFragment fragment) {
        this.activityReference = new WeakReference<>(activity);
        this.fragmentReference = new WeakReference<>(fragment);
        this.fragmentV4Reference = new WeakReference<>(null);
    }

    public EasonHandler(EasonActivity activity, eason.linyuzai.elib.component.v4.EasonFragment fragment) {
        this.activityReference = new WeakReference<>(activity);
        this.fragmentReference = new WeakReference<>(null);
        this.fragmentV4Reference = new WeakReference<>(fragment);
    }

    @Override
    public void handleMessage(Message msg) {
        EasonActivity activity = activityReference.get();
        if (activity != null)
            activity.handleMessage(msg);
        eason.linyuzai.elib.component.EasonFragment fragment = fragmentReference.get();
        if (fragment != null)
            fragment.handleMessage(msg);
        eason.linyuzai.elib.component.v4.EasonFragment fragmentV4 = fragmentV4Reference.get();
        if (fragmentV4 != null)
            fragmentV4.handleMessage(msg);
    }
}
