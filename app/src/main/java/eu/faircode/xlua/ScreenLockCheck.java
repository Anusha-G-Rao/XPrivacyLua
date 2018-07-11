package eu.faircode.xlua;

import android.app.KeyguardManager;
import android.content.Context;

import static android.content.Context.KEYGUARD_SERVICE;

public class ScreenLockCheck {

    public static boolean isPhoneLocked(Context context) {
        KeyguardManager myKM = (KeyguardManager) context.getSystemService(KEYGUARD_SERVICE);
        if( myKM.inKeyguardRestrictedInputMode() ) {
            return true;
        } else {
            return false;
        }

    }
}

