package cs240.fmclient;


import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class LoginOnClick implements View.OnClickListener{
    private EditText host;
    private View view;
    @Override
    public void onClick(View view) {
        if(this.host == null) {
            System.out.println("host is null***");
        }

        String hostname = this.host.getText().toString();
        System.out.println("hostname:" + hostname);
    }
    public LoginOnClick(EditText host, View view) {
        this.host = host;
        this.view = view;
    }
}
