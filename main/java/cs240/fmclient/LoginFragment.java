package cs240.fmclient;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginFragment extends Fragment{

    RadioGroup gender;
    Button login;
    Button register;
    int genderButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Proxy proxy = new Proxy();
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        gender = (RadioGroup) view.findViewById(R.id.genderButtons);
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGender();
                genderButton = gender.getCheckedRadioButtonId();
            }
        });
        login = (Button) view.findViewById(R.id.loginButton);
        register = (Button) view.findViewById(R.id.registerButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginTask().execute();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //proxy.register();
            }
        });
        return view;
    }
    public void getGender() {

    }
}
