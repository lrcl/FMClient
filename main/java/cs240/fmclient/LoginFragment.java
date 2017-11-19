package cs240.fmclient;

import android.app.Fragment;
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

public class LoginFragment extends Fragment implements View.OnClickListener{

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
    private Button register;
    private int genderButton;



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
//        super.onCreateView(inflater,container,savedInstanceState);
        final View view = inflater.inflate(R.layout.login_fragment,container,false);
        host = (EditText) view.findViewById(R.id.hostInput);
        host.setOnClickListener(this);

        port = (EditText) view.findViewById(R.id.portInput);
        port.setOnClickListener(this);

        userName = (EditText) view.findViewById(R.id.userNameInput);
        userName.setOnClickListener(this);

        password = (EditText) view.findViewById(R.id.passwordInput);
        password.setOnClickListener(this);

        firstName = (EditText) view.findViewById(R.id.fNameInput);
        firstName.setOnClickListener(this);

        lastName = (EditText) view.findViewById(R.id.lNameInput);
        lastName.setOnClickListener(this);

        email = (EditText) view.findViewById(R.id.emailInput);
        email.setOnClickListener(this);

//        gender = (RadioGroup) view.findViewById(R.id.genderButtons);
        female = (RadioButton) view.findViewById(R.id.femaleButton);
        female.setOnClickListener(this);

        male = (RadioButton) view.findViewById(R.id.maleButton);
        male.setOnClickListener(this);
//        gender.setOnCheckedChangeListener(this);
        login = (Button) view.findViewById(R.id.loginButton);
        login.setOnClickListener(this);


//            @Override
//            public void onClick(View v) {
//                View parent = (View)v.getParent();
//                EditText temp = parent.findViewById(R.id.hostInput);
//                System.out.println("hehehehe: "+ temp.getText().toString());
//                System.out.println(host.toString());
//                System.out.println("hiiii: " + host.getText().toString());
//                System.out.println("name: " + LoginFragment.this.hostInput[0]);
//                EditText[] input = {host};
//                testHost(input, view);
//                //new LoginTask().execute(input); //need parameters
//            }

        register = (Button) view.findViewById(R.id.registerButton);

        return view;
    }

    @Override
    public void onClick(View v) {
        int counter = 0;
        if(v.getId() == R.id.hostInput) {
            hostname = host.getText().toString();
            counter++;
//            System.out.println(hostname);

        }
        if(v.getId() == R.id.portInput){
            portname = port.getText().toString();
            counter++;
//            System.out.println(portname);
        }
        if(v.getId() == R.id.userNameInput) {
            username = userName.getText().toString();
            counter++;
//            System.out.println(username);
        }
        if(v.getId() == R.id.passwordInput) {
            pword = password.getText().toString();
            counter++;
//            System.out.println(pword);
        }
        if(v.getId() == R.id.fNameInput) {
            fname = firstName.getText().toString();
            counter++;
//            System.out.println(fname);
        }
        if(v.getId() == R.id.lNameInput) {
            lname = lastName.getText().toString();
            counter++;
//            System.out.println(lname);
        }
        if(v.getId() == R.id.emailInput) {
            emailIn = email.getText().toString();
            counter++;
        }
        if(v.getId() == R.id.genderButtons) {
            if(female.isChecked()) {
                genderIn = "f";
            }
            if(male.isChecked()) {
                genderIn = "m";
            }
            counter++;
        }
        if(v.getId() == R.id.loginButton) {

            counter++;
        }
        if(counter >= 9) {
            String[] userInput = {hostname,portname,username,pword,fname,lname,emailIn,genderIn};
            System.out.println("LOGIN BUTTON CLICKED");
            System.out.println("portnumber: " + portname);
            new LoginTask().execute(userInput);
        }
//        System.out.println("end method ----------------------");
    }

//    public void testHost(EditText[] input, View view) {
//        host = (EditText) view.findViewById(R.id.hostInput);
//        if(input[0] == null) {
//            System.out.println("host is null in testHost()");
//        }
//        else {
//            System.out.println("host is NOT Null");
//            System.out.println("get text" + host.getText().toString());
//            host.setText("ahgahghagh");
//            System.out.println("yaaaaoooo" + host.getText().toString());
//        }
//    }
  //  public void onClick(View v) {
    //    this.portInput=  port.getText().toString();
//
 //       System.out.println("name: " + this.portInput);

  //  }
}
