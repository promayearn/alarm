package com.augmentis.ayp.alarm;

import android.content.Context;
import android.os.PowerManager;

/**
 * Created by Chayanit on 8/24/2016.
 */
public class Screen {
    private static final String SCREEN_CLASS_TAG = "SCREEN";

    public Screen() {}

    public void on(Context context) {
        PowerManager powerManager =
                (PowerManager)
                        context.getSystemService(Context.POWER_SERVICE);

        if(!powerManager.isScreenOn()) {
            PowerManager.WakeLock wl = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK |
                            PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE,
                    SCREEN_CLASS_TAG);

            wl.acquire();
            wl.release();
        }
    }
}
