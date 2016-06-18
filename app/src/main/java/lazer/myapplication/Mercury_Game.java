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

/**
 * Mercury Level
 * Level 1 for the player
 */
public class Mercury_Game extends Activity {
    /**User Ship type**/
    ImageView ship;
    JetFighter fighter;
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
        setButtons();
    }
    protected void onResume(){
        super.onResume();
    }
    protected void setButtons()
    {
        //find the ship in the xml layout
        ship= (ImageView) findViewById(R.id.UserShip);
        //set onclicklistener
       // fighter= new JetFighter(this);
        ship.setOnTouchListener(new View.OnTouchListener()
        {
            //the location where the user dragged the image
            PointF drag = new PointF();
            //the location where the image started
            PointF start= new PointF();
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getAction()) {
                    //when the user moves finger on the image
                    case MotionEvent.ACTION_MOVE:
                        //gets the new location where the finger was dragged
                        PointF store = new PointF(event.getX() - drag.x, event.getY() - drag.y);
                        //set the image location to where it was dragged
                        ship.setX((int) (start.x + store.x));
                        ship.setY((int) (start.y) + store.y);
                        start = new PointF(ship.getX(), ship.getY());
                        //method to fire bullets
                        break;
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("Here");
                        attackMode(start);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });

    }
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
        FiringMode thread = new FiringMode(bullet);
        //thread that moves the bullet infinily
        Thread x = new Thread(thread);
        x.start();

    }
}
