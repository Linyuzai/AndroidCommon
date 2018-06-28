package eason.linyuzai.elib.component.v4;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import eason.linyuzai.elib.component.EasonActivity;
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
