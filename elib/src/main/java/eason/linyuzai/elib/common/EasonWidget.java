package eason.linyuzai.elib.common;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EasonWidget {
    public static void printViewTree(View view) {
        printViewTree(view, 0);
    }

    private static void printViewTree(View view, int deep) {
        StringBuilder builder = new StringBuilder();
        String deepStr = "" + deep;
        if (deep < 10)
            deepStr = "0" + deepStr;
        builder.append("deep:").append(deepStr).append(":");
        for (int d = 0; d < deep; d++) {
            builder.append("----");
        }
        builder.append(view.getClass()).append("[id=").append(view.getId());
        if (view instanceof TextView)
            builder.append(",text=").append(((TextView) view).getText());
        builder.append("]\n");
        Log.d("EasonWidget", builder.toString());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                printViewTree(viewGroup.getChildAt(i), deep + 1);
            }
        }
    }
}
