package com.example.back;

import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.widget.EditText;
public class Login extends AppCompatActivity {
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
private  Button login;
    private EditText email;

private TextView signup;

   private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.editText4);
        pass = (EditText) findViewById(R.id.editText5);
        signup=(TextView) findViewById(R.id.textView11);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        //set listeners
        email.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);

        // run once to disable if empty
        checkFieldsForEmptyValues();




    }

    private  void checkFieldsForEmptyValues(){
        Button b = (Button) findViewById(R.id.button);

        String s1 = email.getText().toString();
        String s2 = pass.getText().toString();

        if(s1.equals("") && s2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_SHORT).show();
            b.setEnabled(false);
        }

        else if(!s1.equals("")&&s2.equals("")){
            Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_SHORT).show();
            b.setEnabled(false);
        }

        else if(!s2.equals("")&&s1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_SHORT).show();
            b.setEnabled(false);
        }

        else
        {
            b.setEnabled(true);
        }


        TextView textview=(TextView) findViewById(R.id.textView11);
        String text="<font color=#A9A9A9>Dont have an account?</font> <font color =#0000FF>Sign up</font>";
        textview.setText(Html.fromHtml(text));
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.getText().toString().isEmpty()  ) {
                    Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
                } else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
                        openActivity();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }



    });
    }

    public void openActivity()
    {
        Intent intent =new Intent(this,ContactList.class);
        startActivity(intent);
    }
    public void openActivity1()
    {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
