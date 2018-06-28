package eason.linyuzai.elib.component;

import android.app.Fragment;
import android.os.Handler;
import android.os.Message;

import eason.linyuzai.elib.os.EasonHandler;

public class EasonFragment extends Fragment {

    private Handler handler = new EasonHandler(this);

    public void handleMessage(Message msg) {

    }

    public Handler handler() {
        return handler;
    }

    public EasonActivity eason() {
        return (EasonActivity) getActivity();
    }
}
