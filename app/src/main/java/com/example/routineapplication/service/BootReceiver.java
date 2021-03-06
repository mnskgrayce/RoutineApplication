package com.example.routineapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Call an Intent Service after reboot
public class BootReceiver extends BroadcastReceiver {

    // QUICKBOOT is not in Android docs but apparently for HTC phones?
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ||
                intent.getAction().equals("android.intent.action.QUICKBOOT_POWERON")) {

            Intent i = new Intent(context, RestartAlarmsService.class);
            context.startService(i);
        }
    }
}
