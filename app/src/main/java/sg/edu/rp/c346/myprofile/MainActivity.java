package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGpa;
    RadioGroup rgGender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
    }



    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGpa.getText().toString());
        int genderId = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name",strName);
        prefEdit.putFloat("GPA",gpa);
        prefEdit.putInt("Gender",genderId);
        prefEdit.commit();

    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName = prefs.getString("Name","");
        float gpa = prefs.getFloat("GPA",0);
        int genderId = prefs.getInt("Gender",R.id.radioGroupGender);
        etGpa.setText(String.valueOf(gpa));
        etName.setText(strName);
        rgGender.check(genderId);



    }
}
