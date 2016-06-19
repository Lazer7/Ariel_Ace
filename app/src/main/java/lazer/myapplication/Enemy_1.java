package lazer.myapplication;

import android.app.Activity;
import android.graphics.PointF;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by Jimmy on 6/18/2016.
 */
public class Enemy_1 implements Runnable {
    Activity level;
    ImageView enemy;
    int x_location;
    int y_location;
    /**Get the activity that has the jetfighter**/
    /**
     * Gets the image from the main activity
     * and set default weapon choice
     */
    public Enemy_1(Activity planet){
        //make your own parameters
        level=planet;
        enemy= new ImageView(level);
        RelativeLayout background = (RelativeLayout) level.findViewById(R.id.MercuryRelativeLayout);
        enemy.setImageResource(R.drawable.enemy);
        Random placement= new Random();
        x_location= placement.nextInt(500)+1;
        y_location= placement.nextInt(100)+1;
        enemy.setX(x_location);
        enemy.setY(y_location);
        enemy.bringToFront();
        background.addView(enemy);
    }

    public void run()
    {
        Random placement= new Random();
        System.out.println("enemy movement");
        while(y_location<1500) {
            y_location+= 3;
            enemy.setY(y_location);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
