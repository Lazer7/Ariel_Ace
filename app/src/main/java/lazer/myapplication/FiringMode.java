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
        System.out.println("here");
        for(int i=0; i<100; i++) {
            float startPosition = bullet.getY();
            bullet.setY(startPosition - 10);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
