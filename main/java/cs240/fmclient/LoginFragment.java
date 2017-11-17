package cs240.fmclient;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class LoginFragment extends Fragment{
    Proxy proxy = new Proxy();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        RadioButton radio1 = (RadioButton) view.findViewById(R.id.maleButton);
        RadioButton radio2 = (RadioButton) view.findViewById(R.id.femaleButton);
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGender();
            }
        });
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGender();
            }
        });
        final Button login = (Button) view.findViewById(R.id.loginButton);
        Button register = (Button) view.findViewById(R.id.registerButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxy.login("","","");
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxy.register();
            }
        });
        return view;
    }
    public void getGender() {

    }
}
