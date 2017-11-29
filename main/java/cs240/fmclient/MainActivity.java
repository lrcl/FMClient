package cs240.fmclient;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cs240.fmclient.Models.Person;

public class MainActivity extends AppCompatActivity {
   // public LoginFragment.FragDataTransfer transferPersons;
   // Person[] persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.add(R.id.fragment_container, loginFragment);
        fragmentTransaction.commit();


    }

//    @Override
//    public void onAttachFragment(Fragment fragment) {
//        super.onAttachFragment(fragment);
//        transferPersons = (LoginFragment.FragDataTransfer) fragment;
//    }

//    @Override
//    public Person[] getRelatives(Person[] persons) {
//        this.persons = persons;
//        return persons;
//    }
}
