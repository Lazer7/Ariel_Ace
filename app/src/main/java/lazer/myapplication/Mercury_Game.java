package lazer.myapplication;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class Mercury_Game extends Activity {
    int width;
    int height;
    ImageView ship;
    private LayoutParams layout;
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
                layout = (LayoutParams) ship.getLayoutParams();
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_MOVE:
                        PointF store = new PointF(event.getX()- drag.x,event.getY()-drag.y);
                        ship.setX((int)(start.x+store.x));
                        ship.setY((int)(start.y)+store.y);
                        start=new PointF(ship.getX(),ship.getY());
                        break;
                    default:break;
                }

                return true;
            }

        });

    }
}
