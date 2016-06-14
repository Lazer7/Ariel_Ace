package lazer.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;


/**
 * Ignore this class
 * This activity will be resolved soon
 */
public class Customize extends Activity {
    boolean continueservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customization);
        continueservice=false; //WHY YOU NO WORK

    }
    protected void onStart(){
        super.onStart();
    }
    protected void onResume()
    {
        super.onResume();
        if((OptionMenu.musicOn())&&(!MyService.isActive()))
        {
            startService(new Intent((this), MyService.class));
        }

    }
    protected void onPause(){
        super.onPause();
        if(!continueservice)
        {
            stopService(new Intent(this,MyService.class));
        }

    }
    protected void onDestroy()
    {
        super.onDestroy();
        System.out.println("Destroyed");
    }
    public boolean onKeyDown(int KeyCode, KeyEvent event)
    {
        switch(KeyCode)
        {
            case KeyEvent.KEYCODE_BACK:
            {
                Intent back= new Intent(this,MainActivity.class);
                startActivity(back);
                continueservice=true;
                return true;
            }
        }
        return super.onKeyDown(KeyCode,event);
    }


}
