package lazer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Jimmy on 6/12/2016.
 */
public class JetFighter{
    Activity level;
    ImageView ship;
    /**Get the activity that has the jetfighter**/
    /**
     * Gets the image from the main activity
     * and set default weapon choice
     */
    public JetFighter(Activity planet){
        //make your own parameters
        level=planet;
        provideShip();

    }

    /**
     * Get the user's choice of weapon
     * from the customize activity
     */
    public void weapontype(){
        //make weapons at the customization menu
        //merging Branch test 1
        //merging Branch again test 2
    }
    public void getShipType()
    {

    }

    public void shoot(final PointF start)
    {
        level.runOnUiThread(new Runnable()
        {
            public void run(){
                ImageView bullet = new ImageView(level);
                System.out.println("new bullet made");
                //get weapon type
                bullet.setImageResource(R.drawable.weapon_type);
                //get the panel the ship is in
                RelativeLayout background = (RelativeLayout) level.findViewById(R.id.MercuryRelativeLayout);
                bullet.setX(start.x);
                bullet.setY(start.y);
                //measurements.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                background.addView(bullet);
                FiringMode thread = new FiringMode(bullet, level);
                //thread that moves the bullet infinily
                Thread x = new Thread(thread);
                x.start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void provideShip()
    {
        ship= new ImageView(level);
        ship.setImageResource(R.drawable.shipdesign1);
        //get the panel the ship is in
        RelativeLayout background = (RelativeLayout) level.findViewById(R.id.MercuryRelativeLayout);
        ship.setX(450);
        ship.setY(1400);
        //measurements.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        background.addView(ship);
        ship.setOnTouchListener(new View.OnTouchListener()
        {
            //the location where the user dragged the image
            PointF drag = new PointF();
            //the location where the image started
            PointF start= new PointF();
            public boolean onTouch(View view, MotionEvent event) {
                //attackMode(start);
                shoot(start);
                switch (event.getAction()) {
                    //when the user moves finger on the image
                    case MotionEvent.ACTION_MOVE:
                        //gets the new location where the finger was dragged
                        PointF store = new PointF(event.getX() - drag.x, event.getY() - drag.y);
                        //set the image location to where it was dragged
                        ship.setX((int) (start.x + store.x));
                        ship.setY((int) (start.y) + store.y);
                        if(ship.getX()>900)
                        {
                            ship.setX(start.x);
                        }
                        if(ship.getY()<0||ship.getY()>1550)
                        {
                            ship.setY(start.y);
                        }
                        System.out.println("X:"+ship.getX()+" Y:"+ship.getY());
                        start = new PointF(ship.getX(), ship.getY());
                        //method to fire bullets
                        // attackMode(start);
                        break;
                }
                return true;
            }
        });
    }


}
