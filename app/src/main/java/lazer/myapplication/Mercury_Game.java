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

public class Mercury_Game extends Activity {
    ImageView ship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury__game);
        setButtons();
    }
    protected void setButtons()
    {
        ship= (ImageView) findViewById(R.id.UserShip);
        ship.setOnTouchListener(new View.OnTouchListener()
        {
            PointF drag = new PointF();
            PointF start= new PointF();
            public boolean onTouch(View view, MotionEvent event)
            {

                switch(event.getAction())
                {
                    case MotionEvent.ACTION_MOVE:
                        PointF store = new PointF(event.getX()- drag.x,event.getY()-drag.y);
                        ship.setX((int)(start.x+store.x));
                        ship.setY((int)(start.y)+store.y);
                        start=new PointF(ship.getX(),ship.getY());
                        attackMode();
                        break;
                    default:break;
                }

                return true;
            }

        });
    }
    public void attackMode()
    {
        ImageView bullet= new ImageView(this);
        bullet.setImageResource(R.drawable.weapon_type);
        RelativeLayout background= (RelativeLayout) findViewById(R.id.MercuryRelativeLayout);
        RelativeLayout.LayoutParams measurements= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        measurements.addRule(RelativeLayout.ABOVE,R.id.UserShip);
        measurements.addRule(RelativeLayout.LEFT_OF,R.id.UserShip);
        //measurements.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        background.addView(bullet,measurements);
        FiringMode thread= new FiringMode(bullet);
        Thread x= new Thread(thread);
        x.start();

    }
}
