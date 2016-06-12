package lazer.myapplication;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

/**
 * Option Menu Fragment
 * provides a small menu popup
 * this is displayed in the relative_layout "fragment_container" in the activity_main.xml
 * the fragment layout is in the customization.xml
 */

public class OptionMenu extends Fragment{
    //switch music
    static Switch musicoption;
    //the exit button to close fragment
    Button exitButton;
    //boolean to notify other activities if music is on
    static boolean musicON=true;

    /**
     * empty constructor needed as place holder
     * don't take it into account
     */
    public OptionMenu(){
    }

    /**
     * Creates the Layout and places it in the main_activity layout
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the new layout with fragment
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.newoptionmenu,container,false);
        return view;
    }

    /**
     * Creates the EventListeners for the buttons and switches in the fragment
     * @param savedInstanceState
     */
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //finds the music switch in fragment layout
        musicoption =(Switch) getActivity().findViewById(R.id.Musicswitch1);
        //finds the exit button in the fragment layout
        exitButton= (Button) getActivity().findViewById(R.id.exitButton);
        //checks if the service is currently active
        if(!MyService.isActive())
        {
            //if it is not then turn the switch off
            musicoption.setChecked(false);
        }
        //set the switch event listener with anonymous class
        musicoption.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                System.out.println("IN ONCLICK METHOD");
                //Checks to see if option menu is set off
                if(!musicoption.isChecked())
                {
                    //Set (MUSIC) Service off
                    getActivity().stopService(new Intent((getActivity()), MyService.class));
                    musicON=false;
                }
                else
                {
                    //Set (MUSIC) Service ON
                    getActivity().startService(new Intent((getActivity()),MyService.class));
                    musicON=true;
                }
            }
        });
        //Set Exit Button Function
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                //Remove the Fragment
                getActivity().getFragmentManager().beginTransaction().remove(OptionMenu.this).commit();

            }
        });
    }

    /**
     * checks to see if music is on
     * @return musicON
     */
    public static boolean musicOn()
    {
        return musicON;
    }

}

