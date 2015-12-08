package Controls;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.DatePicker;

/**
 * Created by Isti on 12/8/2015.
 */
public class CustomDatePicker extends DatePicker {

    public CustomDatePicker(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ViewParent parentView = getParent();

        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            if (parentView != null) {
                parentView.requestDisallowInterceptTouchEvent(true);
            }
        }

        return false;
    }
}
