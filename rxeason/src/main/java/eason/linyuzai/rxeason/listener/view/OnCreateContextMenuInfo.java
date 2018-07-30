package eason.linyuzai.rxeason.listener.view;

import android.view.ContextMenu;
import android.view.View;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnCreateContextMenuInfo<E> extends ExtraInfo<E> {
    private ContextMenu contextMenu;
    private View view;
    private ContextMenu.ContextMenuInfo contextMenuInfo;

    OnCreateContextMenuInfo(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.contextMenu = contextMenu;
        this.view = view;
        this.contextMenuInfo = contextMenuInfo;
    }

    public ContextMenu getContextMenu() {
        return contextMenu;
    }

    public View getView() {
        return view;
    }

    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return contextMenuInfo;
    }
}
