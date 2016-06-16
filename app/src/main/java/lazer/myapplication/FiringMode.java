package lazer.myapplication;

import android.widget.ImageView;

/**
 * Created by Jimmy on 6/16/2016.
 */
public class FiringMode implements Runnable {
    ImageView bullet;
    public FiringMode(ImageView x){
        bullet=x;
    }
    public void run()
    {
        for(int i=0; i<100; i++) {
            float startposition = bullet.getY();
            bullet.setY(startposition - 10);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
