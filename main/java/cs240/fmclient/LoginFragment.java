package cs240.fmclient;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText port;
    private EditText host;
    private EditText userName;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private RadioButton female;
    private RadioButton male;
    private RadioGroup gender;
    private Button login;
    private RadioButton register;
    private int genderButton;

    private ArrayList<String> inputStrings = new ArrayList<String>();


    //    private String[] userInput;
    private String hostname;
    private String portname;
    private String username;
    private String pword;
    private String fname;
    private String lname;
    private String emailIn;
    private String genderIn;

    //View view;
//    public void updateHost(String host) {
//        LoginFragment.this.hostInput[0] = host;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        host = (EditText) view.findViewById(R.id.hostInput);
       // host.setOnClickListener(this);

        port = (EditText) view.findViewById(R.id.portInput);
     //   port.setOnClickListener(this);

        userName = (EditText) view.findViewById(R.id.userNameInput);
       // userName.setOnClickListener(this);

        password = (EditText) view.findViewById(R.id.passwordInput);
       // password.setOnClickListener(this);

        firstName = (EditText) view.findViewById(R.id.fNameInput);
       // firstName.setOnClickListener(this);

        lastName = (EditText) view.findViewById(R.id.lNameInput);
       // lastName.setOnClickListener(this);

        email = (EditText) view.findViewById(R.id.emailInput);
//        email.setOnClickListener(this);

//        gender = (RadioGroup) view.findViewById(R.id.genderButtons);
        female = (RadioButton) view.findViewById(R.id.femaleButton);
  //      female.setOnClickListener(this);

        male = (RadioButton) view.findViewById(R.id.maleButton);
    //    male.setOnClickListener(this);
//        gender.setOnCheckedChangeListener(this);
        login = (Button) view.findViewById(R.id.loginButton);
        login.setOnClickListener(this);

        register = (RadioButton) view.findViewById(R.id.registerButton);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        this.hostname = host.getText().toString();
        this.portname = port.getText().toString();
        this.username = userName.getText().toString();
        this.pword = password.getText().toString();
        this.fname = firstName.getText().toString();
        this.lname = lastName.getText().toString();
        this.emailIn = email.getText().toString();
        if (female.isChecked()) {
            this.genderIn = "f";
        }
        if (male.isChecked()) {
            this.genderIn = "m";
        }
         if(((Button)v).getText().toString().equals("SIGN IN")) {
            System.out.println("login button clicked");
            String[] userInput = {hostname, portname, username, pword, fname, lname, emailIn, genderIn};
            new LoginTask(getActivity().getApplicationContext()).execute(userInput);
        }
        if (register.isChecked()) {
            System.out.println("REGISTER BUTTON CLICKED");
            String[] userInput = {hostname, portname, username, pword, fname, lname, emailIn, genderIn};
            new RegisterTask(getActivity().getApplicationContext()).execute(userInput);
        }
//        System.out.println("end method ----------------------");
    }

    public LoginFragment() {}
}