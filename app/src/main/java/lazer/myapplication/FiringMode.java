package lazer.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jimmy on 6/16/2016.
 */
public class FiringMode implements Runnable {
    ImageView bullet;
    Activity level;
    public FiringMode(ImageView x,Activity planet)
    {
        bullet=x;
        level=planet;
    }
    public void run()
    {
        System.out.println("here");
        for(int i=0; i<100; i++) {


            try {
                Thread.sleep(100);
                level.runOnUiThread(new Runnable()
                {
                    public void run(){
                        float startPosition = bullet.getY();
                        bullet.setY(startPosition - 10);
                    }
                });
                {

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
