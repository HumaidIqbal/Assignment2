package pk.edu.uiit.arid2480.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ToggleButton tbColor;
    ImageButton btnHelp;
    EditText etName, etEmail,etPassword;
    RadioGroup rgGender;
    TextView tvSeeker;
    CheckBox cbEnglish,cbUrdu,cbPunjabi;
    Button btnSubmit;
    SeekBar sbBrightness;
    RadioButton rbButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        performaction();
    }

    private void performaction() {
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.background),"Fill all the Field!!",Snackbar.LENGTH_LONG).show();
            }
        });
        tbColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                findViewById(R.id.background).setBackgroundColor(Color.DKGRAY);
                }
                else{
                    findViewById(R.id.background).setBackgroundColor(Color.WHITE);
                }
            }
        });
        sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvSeeker.setTextSize(progress+1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message ="";
                int selectedid = rgGender.getCheckedRadioButtonId();
                rbButton = (RadioButton) findViewById(selectedid);
                message += etName.getText().toString() +" "+ etEmail.getText().toString()+" "+rbButton.getText().toString();
                if(cbEnglish.isChecked()){
                    message +="English";
                }
                if(cbUrdu.isChecked()){
                    message +="Urdu";
                }
                if(cbPunjabi.isChecked()){
                    message += "Punjabi";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });

    }

    private void initialize() {
        tbColor = (ToggleButton) findViewById(R.id.tbButton);
        btnHelp= (ImageButton) findViewById(R.id.btnImage);
        etName =(EditText) findViewById(R.id.etName);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        cbEnglish = (CheckBox) findViewById(R.id.cbEnglish);
        cbUrdu = (CheckBox) findViewById(R.id.cbUrdu);
        cbPunjabi = (CheckBox) findViewById(R.id.cbPunjabi);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        sbBrightness = (SeekBar) findViewById(R.id.sbBrightness);
        tvSeeker = (TextView) findViewById(R.id.tvSeeker);
    }
}