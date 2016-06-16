package lazer.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Jimmy Chao
 * Project 0
 * Team Lazer
 */

public class MainActivity extends Activity {
    Button Play;
    Button Customization;
    Button Option;
    boolean CustomizationSelected;
    boolean PlayButtonSelected;
    OptionMenu OptionMenu;
    RelativeLayout Main;
    /**
     * On create lifecycle for the Main Menu
     * Main menu screen creation currently sets onClickListeners for buttons
     * Calls the Layout for the Main Menu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("NOTLIKETHIS");
        OptionMenu =  new OptionMenu();
        setButtons();
    }

    /**
     * On Start lifecycle for the Main Menu
     * Starts the service depending on whether it's not active
     * or due to customization settings
     */
    @Override
    protected void onStart(){
        super.onStart();
        //Checks to see if music switch is on
        //then checks to see if the service is active
        if((OptionMenu.musicOn())&&(!MyService.isActive()))
        {
            startService(new Intent((this), MyService.class));
        }
        System.out.println("STARTMAIN");
    }
    protected void onResume()
    {
        super.onResume();

    }

    /**
     * On Pause Life Cycle for the Main menu
     * currently nothing
     */
    protected void onPause()
    {
        super.onPause();
        System.out.println("PAUSEDMAIN");
    }

    /**
     * On stop Lifecycle for Main Menu
     * When user goes to another activity or home menu
     * stop the service if they go to the home menu
     * if not continue the service
     */
    protected void onStop()
    {
        super.onStop();
        System.out.println("onStop");
        //checks to see if option button has been selected
        //this shows that the user has enter the option menu
        if(!CustomizationSelected&&!PlayButtonSelected)
        {
            //if option menu has not been selected
            //then stop service
            stopService(new Intent((this), MyService.class));
        }

        //set option menu to false to reset the check
        CustomizationSelected =false;
        PlayButtonSelected=false;

    }

    /**
     * On Destroy Lifecycle currently ends life of entire app
     * releases media player and stop service
     */
    protected void onDestroy()
    {
        super.onDestroy();
        stopService(new Intent((this), MyService.class));
        System.out.println("DestroyedMAIN");
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
    //lifecycle go to for when device changes rotation
        int orientation= this.getResources().getConfiguration().orientation;
        if(orientation==1) {
            super.onConfigurationChanged(newConfig);
            setContentView(R.layout.activity_main);
            setButtons();
        }
        else
        {
            super.onConfigurationChanged(newConfig);
            setContentView(R.layout.activity_main_landscape);
            setButtons();
        }
    }

    /**
     * finds and set listeners for all widgets
     */
    public void setButtons()
    {
        Play= (Button) findViewById(R.id.Play);
        Customization = (Button) findViewById(R.id.Customize);
        Option = (Button) findViewById(R.id.OptionMenu);
        CustomizationSelected =false;
        PlayButtonSelected=false;
        Play.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                PlayButtonSelected=true;
                Intent LevelSelection = new Intent(MainActivity.this, Mercury_Game.class);
                startActivity(LevelSelection);
            }
        });
        Customization.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                CustomizationSelected =true;
                Intent option = new Intent(MainActivity.this, lazer.myapplication.Customize.class);
                startActivity(option);

            }
        });
        Option.setOnClickListener(new View.OnClickListener()
        {
            //FragmentManager fragmentManager = getFragmentManager();
            //This gets the tool to focus on the OptionMenu Fragments

            public void onClick(View view)
            {
                //Create the OptionMenu option Fragment menu
                FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                //Use this tool to get fragment layout
                fragmentTransaction.replace(R.id.fragment_container, OptionMenu);
                //show the fragment
                fragmentTransaction.commit();
                //Get the fragment layout
                Main= (RelativeLayout) findViewById(R.id.fragment_container);
                //set it to the front of the screen
                Main.bringToFront();
                Main.invalidate();

            }
        });
    }


}
