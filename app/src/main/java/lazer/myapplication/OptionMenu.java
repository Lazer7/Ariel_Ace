package lazer.myapplication;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;


public class OptionMenu extends Fragment{
    static Switch musicoption;
    Button exitButton;
    static boolean musicON=true;
    public OptionMenu(){
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.newoptionmenu,container,false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        musicoption =(Switch) getActivity().findViewById(R.id.Musicswitch1);
        exitButton= (Button) getActivity().findViewById(R.id.exitButton);
        if(!MyService.isActive()){musicoption.setChecked(false);}

        musicoption.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                System.out.println("IN ONCLICK METHOD");
                if(!musicoption.isChecked())
                {
                    System.out.println("On");
                    getActivity().stopService(new Intent((getActivity()), MyService.class));
                    musicON=false;
                }
                else
                {
                    System.out.println("OFF");
                    getActivity().startService(new Intent((getActivity()),MyService.class));
                    musicON=true;
                }
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                System.out.println("HERE");
                getActivity().getFragmentManager().beginTransaction().remove(OptionMenu.this).commit();

            }
        });
    }
    public static boolean musicOn()
    {
        return musicON;
    }

}

