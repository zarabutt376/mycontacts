package com.example.back;
import android.text.Editable;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.String;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.regex.Pattern;
import android.util.Patterns;

public class MainActivity extends AppCompatActivity {


    private Button signup;
    private EditText name;
    private EditText email;
    private EditText password;
private TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        name = (EditText) findViewById(R.id.editText3);

      signin=(TextView) findViewById(R.id.textView10) ;

signin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity1();
    }
});


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textview = (TextView) findViewById(R.id.textView10);
        String text = "<font color=#A9A9A9>have an account?</font> <font color =#0000FF>Sign in</font>";
        textview.setText(Html.fromHtml(text));
        signup = (Button) findViewById(R.id.button2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.getText().toString().isEmpty()  && password.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
                } else {
                    if (email.getText().toString().trim().matches(emailPattern) ) {
                        Toast.makeText(getApplicationContext(), "valid information", Toast.LENGTH_SHORT).show();
                        openActivity();
                    } else {
                        Toast.makeText(getApplicationContext(), "Recheck your email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }



        });
    }

    public void openActivity() {

        Intent intent = new Intent(this, ContactList.class);
        startActivity(intent);
    }
    public void openActivity1() {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}

