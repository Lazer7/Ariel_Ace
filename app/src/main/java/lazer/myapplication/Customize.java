package lazer.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Customize extends AppCompatActivity {
    static Switch musicoption;
    static boolean musicON=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customization);
        musicoption =(Switch) findViewById(R.id.Musicswitch);
        if(!MyService.isActive()){musicoption.setChecked(false);}
        musicoption.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(!musicoption.isChecked())
                {
                    stopService(new Intent((Customize.this), MyService.class));
                    musicON=false;
                }
                else
                {
                    startService(new Intent((Customize.this),MyService.class));
                    musicON=true;
                }
            }
        });
    }
    protected void onResume()
    {
        super.onResume();
        if(musicON&& !MyService.isActive())
        {
            startService(new Intent((Customize.this),MyService.class));
        }
    }
    protected void onPause(){
        super.onPause();
        if (!this.isFinishing()){
            System.out.println("HOMEBUTTON");
            stopService(new Intent((Customize.this),MyService.class));
        }
    }
    protected void onDestroy()
    {
        super.onDestroy();
        System.out.println("Destroyed");
    }

    public static boolean musicOn()
    {
        return musicON;
    }
}
