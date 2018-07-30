package eason.linyuzai.rxeason.listener.viewgroup;

import android.view.View;
import android.view.ViewGroup;

import eason.linyuzai.rxeason.listener.RxListener;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.Flowable;

public class ViewGroupListenerSetter<Setter extends ViewGroupListenerSetter, V extends ViewGroup, Info extends ViewGroupInfo<V>>
        extends ViewListenerSetter<Setter, V, Info> {

    @SuppressWarnings("unchecked")
    @Override
    public Info newViewInfo(V view) {
        return (Info) new ViewGroupInfo<>(view);
    }

    @Override
    public void destroy() {
        removeHierarchyChange();
        super.destroy();
    }

    public Flowable<OnHierarchyChangeInfo> onHierarchyChange() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                emitter.onNext(new OnHierarchyChangeInfo(parent, child, true, false));
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                emitter.onNext(new OnHierarchyChangeInfo(parent, child, false, true));
            }
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeHierarchyChange() {
        getViewInfo().getView().setOnHierarchyChangeListener(null);
    }
}
