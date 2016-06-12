package lazer.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


/**
 * Created by Jimmy on 5/31/2016.
 */
public class MyService extends Service {
    MediaPlayer music;
    static boolean Running;

    /** indicates how to behave if the service is killed */
    int mStartMode;

    /** interface for clients that bind */
    IBinder mBinder;

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

    /** Called when the service is being created. */

    /** The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        music= MediaPlayer.create(this, R.raw.monody);
        music.setLooping(true);
        music.start();
        Running=true;
        System.out.println("SERVICE STARTING "+ Running);
        return mStartMode;
    }

    /** A client is binding to the service with bindService() */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** Called when all clients have unbound with unbindService() */
    @Override
    public boolean onUnbind(Intent intent) {
        return mAllowRebind;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {

    }
    /** Called when The service is no longer used and is being destroyed */
    @Override
    public void onDestroy() {
        music.stop();
        music.release();
        Running=false;
        System.out.println("SERVICE DESTROYED");
    }
    public static boolean isActive(){return Running;}
}
