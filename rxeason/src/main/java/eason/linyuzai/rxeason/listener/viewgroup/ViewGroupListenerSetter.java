package eason.linyuzai.rxeason.listener.viewgroup;

import android.view.View;
import android.view.ViewGroup;

import eason.linyuzai.rxeason.RxEason;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.Flowable;

public class ViewGroupListenerSetter extends ViewListenerSetter {
    @Override
    public ViewGroupInfo[] getViewInfos() {
        return (ViewGroupInfo[]) super.getViewInfos();
    }

    @Override
    public ViewInfo newViewInfo(View view) {
        return new ViewGroupInfo(view);
    }

    public Flowable<OnHierarchyChangeInfo> onHierarchyChange() {
        return Flowable.create(emitter -> {
            for (ViewGroupInfo vi : getViewInfos()) {
                vi.getView().setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                    @Override
                    public void onChildViewAdded(View parent, View child) {
                        emitter.onNext(new OnHierarchyChangeInfo(parent, child, true, false));
                    }

                    @Override
                    public void onChildViewRemoved(View parent, View child) {
                        emitter.onNext(new OnHierarchyChangeInfo(parent, child, false, true));
                    }
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeHierarchyChange() {
        for (ViewGroupInfo vi : getViewInfos()) {
            vi.getView().setOnHierarchyChangeListener(null);
        }
    }

    public static class ViewGroupInfo extends ViewInfo {

        ViewGroupInfo(View view) {
            super(view);
        }

        @Override
        public ViewGroup getView() {
            return (ViewGroup) super.getView();
        }
    }
}
