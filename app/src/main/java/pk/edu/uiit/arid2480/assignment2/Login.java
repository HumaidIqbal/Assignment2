package pk.edu.uiit.arid2480.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnlogin;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        performaction();
    }

    private void performaction() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                Cursor user_data = dbHelper.login(email,password);
                if(user_data.moveToFirst()){

                    Toast.makeText(Login.this, "Log In Successfull", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,Student_Card.class);
                     @SuppressLint("Range") String name = user_data.getString(user_data.getColumnIndex("student_name"));
                     @SuppressLint("Range") String phone = user_data.getString(user_data.getColumnIndex("student_phone"));
                     @SuppressLint("Range") String country = user_data.getString(user_data.getColumnIndex("student_country"));

                     intent.putExtra("Name",name);
                     intent.putExtra("Email",email);
                     intent.putExtra("Phone",phone);
                     intent.putExtra("Country",country);

                    startActivity(intent);

                }
                else{
                    Toast.makeText(Login.this, "User not Exist", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void initialize() {
        dbHelper =new DBHelper(this);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
    }
}