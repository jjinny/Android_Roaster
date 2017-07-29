package com.example.jjin5783.roster;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.jjin5783.roster.R.id.checkBox;
import static com.example.jjin5783.roster.R.id.inputName;
import static com.example.jjin5783.roster.R.id.parent;
import static com.example.jjin5783.roster.R.id.selectEyeColor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSpinner();

        //Manipulate a Picker Calendar UI Control The user must be able to view a person’s birthday and manipulate it using a Picker Calendar UI element
        Button calendar =(Button) findViewById(R.id.buttonCalendar);
        calendar.setOnClickListener(new  View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                final int[] year = {0};
                final int[] month = new int[1];
                final int[] day = new int[1];

                // Process to get Current Date
                if (year[0] == 0) {
                    final Calendar c = Calendar.getInstance();
                    year[0] = c.get(Calendar.YEAR);
                    month[0] = c.get(Calendar.MONTH);
                    day[0] = c.get(Calendar.DAY_OF_MONTH);
                }

                // Launch Date Picker Dialog
                DatePickerDialog.OnDateSetListener datePickerListener
                        = new DatePickerDialog.OnDateSetListener() {

                    // when dialog box is closed, below method will be called.
                    public void onDateSet(DatePicker view, int selectedYear,
                                          int selectedMonth, int selectedDay) {

                        TextView tvDisplayDate = (TextView) findViewById(R.id.textBirthday);
                        DatePicker dpResult = (DatePicker) findViewById(R.id.dpResult);

                        year[0] = selectedYear;
                        month[0] = selectedMonth;
                        day[0] = selectedDay;

                        // set selected date into textview
                        tvDisplayDate.setText(new StringBuilder().append(month[0] + 1)
                                .append("-").append(day[0]).append("-").append(year[0])
                                .append(" "));

                        // set selected date into datepicker also
                        dpResult.init(year[0], month[0], day[0], null);

                    }
                };
            }
        });
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean checked = ((RadioButton) v).isChecked();
                RadioButton rb;
                switch (R.id.radioGroup){
                    case R.id.XS:
                        rb = (RadioButton)findViewById(R.id.XS);
                        break;
                    case R.id.S:
                        rb = (RadioButton)findViewById(R.id.S);
                        break;
                    case R.id.M:
                        rb = (RadioButton)findViewById(R.id.M);
                        break;
                    case R.id.L:
                        rb = (RadioButton)findViewById(R.id.L);
                        break;
                    case R.id.XL:
                        rb = (RadioButton)findViewById(R.id.XL);
                        break;
                    case R.id.XXL:
                    default:
                        rb = (RadioButton)findViewById(R.id.XXL);
                        break;
                }
                rb.toggle();
            }
        });

        SeekBar sb;
        TextView tv;
        sb = (SeekBar)this.findViewById(R.id.seekBar1);
        final int[] slider1 = {0};
        sb.setProgress(slider1[0]);
        tv = (TextView)findViewById(R.id.pants);
        tv.setText("Pant Size: " + slider1[0] + "/" + sb.getMax());
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                slider1[0] = progresValue;
                TextView tv = (TextView)findViewById(R.id.pants);
                tv.setText("Pant Size: " + slider1[0] + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //shorts
        SeekBar shirts = (SeekBar)this.findViewById(R.id.seekBar2);
        final int[] slider2 = {0};
        shirts.setProgress(slider2[0]);
        TextView textShorts = (TextView)findViewById(R.id.shirts);
        textShorts.setText("Shirts Size: " + slider2[0] + "/" + shirts.getMax());
        shirts.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                slider2[0] = progresValue;
                TextView textShorts = (TextView)findViewById(R.id.shirts);
                textShorts.setText("Shirts Size: " + slider2[0] + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //shoes
        SeekBar shoe = (SeekBar)this.findViewById(R.id.seekBar3);
        final int[] slider3 = {0};
        shoe.setProgress(4);
        TextView textShoe = (TextView)findViewById(R.id.shoe);
        textShoe.setText("Shoe Size: " + 4 + "/" + shoe.getMax());
        shoe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                slider3[0] = progresValue;
                TextView textShoe = (TextView)findViewById(R.id.shoe);
                textShoe.setText("Shoe Size: " + slider3[0] + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // save data to preference
        Button save = (Button) findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            //Create method for displaying textfield content
            public void onClick(View v)
            {
                EditText et = (EditText) findViewById(R.id.inputName);
                //checkbox
                final CheckBox check = (CheckBox) findViewById(R.id.checkBox);
                //RaduiGroup(shirt size)
                RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
                int selectedOption = rg.getCheckedRadioButtonId();


                // save data to shared preferences
                SharedPreferences prefs = getSharedPreferences("User", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                // Save User Name
                editor.putString("Username", et.toString());
                // Save Check Box
                editor.putInt("check", check.isChecked() ? 1 : 0);
                // Save Eye Color
                editor.putInt("eye color", );
                // Save Calender
                editor.putInt("year", nYear);
                editor.putInt("month", nMonth);
                editor.putInt("day", nDay);
                // 5. Radio Selector
                editor.putInt("shirt size", selectedOption);
                // 6. Three Slider
                editor.putInt("pants size", slider1[0]);
                editor.putInt("short size", slider2[0]);
                editor.putInt("shoe size", slider3[0]);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });

    }
        // initialize spin control
        private void addSpinner() {
            List eyeColor = new ArrayList<String>();
            eyeColor.add("Black");
            eyeColor.add("Brown");
            eyeColor.add("Blue");
            eyeColor.add("Green");

            Spinner spinner = (Spinner) findViewById(selectEyeColor);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, eyeColor);
            //property of spinner
            spinner.setPrompt("Select your eye colour");
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                        }
                    }
            );
        }

}
