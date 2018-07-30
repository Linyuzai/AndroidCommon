package eason.linyuzai.rxeason.listener.viewgroup;

import android.view.View;
import android.view.ViewGroup;

import eason.linyuzai.rxeason.ExtraGetter;
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

    public <E> Flowable<OnHierarchyChangeInfo<E>> onHierarchyChange() {
        return onHierarchyChange(null);
    }

    public <E> Flowable<OnHierarchyChangeInfo<E>> onHierarchyChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                OnHierarchyChangeInfo<E> info = new OnHierarchyChangeInfo<>(parent, child,
                        true, false);
                if (getter != null) {
                    info.setExtra(getter.getExtra());
                }
                emitter.onNext(info);
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                OnHierarchyChangeInfo<E> info = new OnHierarchyChangeInfo<>(parent, child,
                        false, true);
                if (getter != null) {
                    info.setExtra(getter.getExtra());
                }
                emitter.onNext(info);
            }
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeHierarchyChange() {
        getViewInfo().getView().setOnHierarchyChangeListener(null);
    }
}
