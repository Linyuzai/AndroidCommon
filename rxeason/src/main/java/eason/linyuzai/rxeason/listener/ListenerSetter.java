package eason.linyuzai.rxeason.listener;

import android.view.View;

@SuppressWarnings("unchecked")
public abstract class ListenerSetter<Setter extends ListenerSetter, V extends View, Info extends ListenerInfo<V>> {

    private Info[] viewInfos;

    public Setter bind(V[] views) {
        viewInfos = (Info[]) new ListenerInfo[views.length];
        for (int i = 0; i < views.length; i++)
            viewInfos[i] = newViewInfo(views[i]);
        return (Setter) this;
    }

    public abstract Info newViewInfo(V view);

    protected Info[] getViewInfos() {
        return viewInfos;
    }

    @Deprecated
    public Setter filter(int... indexArray) {
        for (int i = 0; i < viewInfos.length; i++) {
            boolean isMatched = false;
            for (int index : indexArray) {
                if (i == index) {
                    isMatched = true;
                    break;
                }
            }
            viewInfos[i].setFiltered(isMatched);
        }
        return (Setter) this;
    }

    @Deprecated
    public Setter filter(V... viewArray) {
        for (Info vi : viewInfos) {
            boolean isMatched = false;
            for (V v : viewArray) {
                if (vi.getView().equals(v)) {
                    isMatched = true;
                    break;
                }
            }
            vi.setFiltered(isMatched);
        }
        return (Setter) this;
    }
}
