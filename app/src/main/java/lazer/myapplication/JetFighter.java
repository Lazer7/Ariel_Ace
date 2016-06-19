package lazer.myapplication;

import android.app.Activity;
import android.graphics.PointF;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Jimmy on 6/12/2016.
 */
public class JetFighter {
    Activity level;
    /**Get the activity that has the jetfighter**/
    /**
     * Gets the image from the main activity
     * and set default weapon choice
     */
    public JetFighter(Activity planet){
        //make your own parameters
        level=planet;
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
    public void attackMode(PointF start)
    {
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
        FiringMode thread = new FiringMode(bullet,level);
        //thread that moves the bullet infinily
        Thread x = new Thread(thread);
        x.start();
    }

}
