package cs240.fmclient;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginFragment extends Fragment{

    private EditText port;
    private EditText host;
    private String[] userInput;
    private RadioGroup gender;
    private Button login;
    private Button register;
    private int genderButton;



    final private String[] hostInput = new String[1];
    private String portInput;
    private String userNameIn;
    private String passwordIn;
    private String firstNameIn;
    private String lastNameIn;
    private String emailIn;
    private String genderIn;
    public void updateHost(String host) {
        LoginFragment.this.hostInput[0] = host;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Proxy proxy = new Proxy();
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        host = (EditText) view.findViewById(R.id.hostInput);
        final String[] hostInput = new String[1];
        host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHost(host.getText().toString());
                System.out.println("host on click called **");
            }
        });

        port = (EditText) view.findViewById(R.id.portInput);
      /*  port.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portInput = port.getText().toString();
            }
        });*/
        gender = (RadioGroup) view.findViewById(R.id.genderButtons);
     /*   gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderButton = gender.getCheckedRadioButtonId();
            }
        });*/
        login = (Button) view.findViewById(R.id.loginButton);
        register = (Button) view.findViewById(R.id.registerButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            System.out.println("name: " + LoginFragment.this.hostInput[0]);
               // new LoginTask().execute(); //need parameters
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
