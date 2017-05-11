package hackeru.edu.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 11/05/2017.
 */

public class Intents {


    /**
     * <uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
     *
     * @param context
     * @param message
     * @param seconds
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void startTimer(Context context, String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
