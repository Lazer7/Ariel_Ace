package lazer.myapplication;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.Random;

/**
 * Mercury Level
 * Level 1 for the player
 */
public class Mercury_Game extends Activity {
    /**User Ship type**/
    ImageView ship;
    JetFighter fighter;
    Enemy_1[] attackers=new Enemy_1[400];
    /**
     * creating the level
     * sets the layout and buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury__game);
        //sets buttons
        //set's ship movement
        //and ship's firing mode
        JetFighter fighter= new JetFighter(this);

    }
    protected void onResume(){
        super.onResume();
        Enemy_1 x= new Enemy_1(this);
        Thread go= new Thread(x);
        go.start();
    }

    //firing mode reference
 /*
    public void attackMode(PointF start)
    {
        ImageView bullet = new ImageView(this);
        System.out.println("new bullet made");
        //get weapon type
        bullet.setImageResource(R.drawable.weapon_type);
        //get the panel the ship is in
        RelativeLayout background = (RelativeLayout) findViewById(R.id.MercuryRelativeLayout);
        bullet.setX(start.x);
        bullet.setY(start.y);
        //measurements.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        background.addView(bullet);
        FiringMode thread = new FiringMode(bullet,this);
        //thread that moves the bullet infinily
        Thread x = new Thread(thread);
        x.start();
        System.out.println(count++);
    }
    */
}
