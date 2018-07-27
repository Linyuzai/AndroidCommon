package eason.linyuzai.rxeason.listener;

import android.view.View;

@SuppressWarnings("unchecked")
public abstract class ListenerSetter {

    private ListenerInfo[] viewInfos;

    public void bind(View[] views) {
        viewInfos = new ListenerInfo[views.length];
        for (int i = 0; i < views.length; i++)
            viewInfos[i] = newViewInfo(views[i]);
    }

    public abstract <Info extends ListenerInfo> Info newViewInfo(View view);

    public <Info extends ListenerInfo> Info[] getViewInfos() {
        return (Info[]) viewInfos;
    }
}
