package lazer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelectionScreen extends Activity {
    Button [] Planets= new Button[9];
    Button backButton;
    boolean continueservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection_screen);
        setButtons();
        continueservice=false;
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
    public void setButtons()
    {
        Planets[0]= (Button)findViewById(R.id.Mercury);
        Planets[1]= (Button)findViewById(R.id.Venus);
        Planets[2]= (Button)findViewById(R.id.Mars);
        Planets[3]= (Button)findViewById(R.id.Earth);
        Planets[4]= (Button)findViewById(R.id.Jupiter);
        Planets[5]= (Button)findViewById(R.id.Saturn);
        Planets[6]= (Button)findViewById(R.id.Uranus);
        Planets[7]= (Button)findViewById(R.id.Neptune);
        Planets[8]= (Button)findViewById(R.id.Pluto);
        backButton= (Button) findViewById(R.id.BackButton);
        for(int i=0; i<9; i++){
            Planets[i].setOnClickListener(new listener());
        }
        backButton.setOnClickListener(new listener());
    }

    private class listener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.Mercury:
                    System.out.println("Coming soon");
                    break;
                case R.id.Venus:
                    System.out.println("Coming soon");
                    break;
                case R.id.Earth:
                    System.out.println("Coming soon");
                    break;
                case R.id.Mars:
                    System.out.println("Coming soon");
                    break;
                case R.id.Jupiter:
                    System.out.println("Coming soon");
                    break;
                case R.id.Saturn:
                    System.out.println("Coming soon");
                    break;
                case R.id.Uranus:
                    System.out.println("Coming soon");
                    break;
                case R.id.Neptune:
                    System.out.println("Coming soon");
                break;
                case R.id.Pluto:
                    System.out.println("Coming soon");
                    break;
                case R.id.BackButton:
                    Intent back = new Intent(LevelSelectionScreen.this,MainActivity.class);
                    startActivity(back);
                    break;
            }
        }
    }

}
