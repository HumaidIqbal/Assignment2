package pk.edu.uiit.arid2480.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    EditText etName,etEmail,etPhone,etPassword,etRetype,etCountry;
    Button  btnRegister,btnReset;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        initialize();
        performaction();
    }

    private void performaction() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString();
                String Email = etEmail.getText().toString();
                String Phone = etPhone.getText().toString();
                String Password = etPassword.getText().toString();
                String Retype = etRetype.getText().toString();
                String Country = etCountry.getText().toString();
                if(Password.equals(Retype)){
                    long userdata = db.singup(Name,Email,Password,Phone,Country);
                    if(userdata == -1){
                        Toast.makeText(Question2.this, "Error Occur", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Question2.this, "Added Successfully ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Question2.this,Login.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(Question2.this, "Password Doesn't Matched", Toast.LENGTH_LONG).show();
                }


            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etEmail.setText("");
                etPhone.setText("");
                etPassword.setText("");
                etRetype.setText("");
                etCountry.setText("");
            }
        });
    }


    private void initialize() {
        db = new DBHelper(this);
        etName = (EditText)     findViewById(R.id.etName1);
        etEmail = (EditText)    findViewById(R.id.etEmail1);
        etPhone = (EditText)    findViewById(R.id.etPhone1);
        etPassword = (EditText) findViewById(R.id.etPassword1);
        etRetype = (EditText)   findViewById(R.id.etRetype1);
        etCountry = (EditText)  findViewById(R.id.etCountry1);
        btnRegister = (Button)  findViewById(R.id.btnRegister);
        btnReset = (Button)     findViewById(R.id.btnReset);

    }
}