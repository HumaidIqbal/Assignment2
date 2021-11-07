package pk.edu.uiit.arid2480.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Card extends AppCompatActivity {
    TextView tvName,tvEmail,tvPhone,tvCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_card);
        intialize();
        activitydata();

    }

    private void activitydata() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String email = intent.getStringExtra("Email");
        String phone = intent.getStringExtra("Phone");
        String country = intent.getStringExtra("Country");
        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvCountry.setText(country);
    }

    private void intialize() {
        tvName =(TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvCountry = (TextView) findViewById(R.id.tvCountry);
    }
}