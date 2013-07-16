package pt.uminho.myenergy;

import android.app.Application;

import com.testflightapp.lib.TestFlight;


/**
 * Created by arsenio on 12-07-2013.
 */
public class MyEnergyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        TestFlight.takeOff(this, "d4ff6918-1247-4169-bf7b-f92b0939626d");
    }
}
