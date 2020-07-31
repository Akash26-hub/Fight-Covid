package com.example.fightcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.fightcovid.R.id.checkBox;
import static com.example.fightcovid.R.id.checkBox2;
import static com.example.fightcovid.R.id.checkBox3;
import static com.example.fightcovid.R.id.checkBox4;
import static com.example.fightcovid.R.id.checkBox5;
import static com.example.fightcovid.R.id.editText2;
import static com.example.fightcovid.R.id.seekBar;
import static com.example.fightcovid.R.id.seekBar4;

public class OrderActivity extends AppCompatActivity {
    EditText age, day;
    SeekBar s1,s2;
    CheckBox c1,c2,c3,c4,c5;
    String ageI,dayI;
    int ValueA,ValueF=0;

    public void backbtn3(View view){
        onBackPressed();
    }
    public void toaster(View view){
        Toast.makeText(getApplicationContext(),"IMPORTANT NOTE: This app is just for mere prediction, do consult a physician",Toast.LENGTH_SHORT).show();
    }
    public void onresultcheck(View view) {
        age = (EditText) findViewById(R.id.editText2);
        day = (EditText) findViewById(R.id.editText3);
        s1 = (SeekBar) findViewById(R.id.seekBar4);
        s2 = (SeekBar) findViewById(R.id.seekBar);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
        c4 = (CheckBox) findViewById(R.id.checkBox4);
        c5 = (CheckBox) findViewById(R.id.checkBox5);
        ageI = OrderActivity.this.age.getText().toString();
        dayI = OrderActivity.this.day.getText().toString();
        {
            if (!"".equals(OrderActivity.this.dayI)) {
                OrderActivity.this.ValueF = Integer.parseInt(OrderActivity.this.dayI);
            }
            if (!"".equals(OrderActivity.this.ageI)) {
                OrderActivity.this.ValueA = Integer.parseInt(OrderActivity.this.ageI);
            }
        }/*
            if(c1.isChecked()){
                fl1=1;
            }
            if(c2.isChecked()){
                fl2=1;
            }
            if(c3.isChecked()){
                fl3=1;
            }
            if(c4.isChecked()){
                fl4=1;
            }
            if(c5.isChecked()){
                fl5=1;
            }*/
        if ((age.getText().toString().trim().length() > 0 )&&(day.getText().toString().trim().length()>0)) {
            if ((ValueF == 0) || (ValueA == 0)) { Toast.makeText(getApplicationContext(), "Enter valid input", Toast.LENGTH_SHORT).show();}
            //else if((ValueF == 0) || (ValueA > 0)){Toast.makeText(getApplicationContext(), "Check", Toast.LENGTH_SHORT).show();}

            else {
                if ((ValueF >= 14 || s1.getProgress() > 2 || ValueA > 10 || s2.getProgress() > 1) && (ValueF >= 14 || s1.getProgress() > 2 || ValueA > 56 || s2.getProgress() > 1)) {
                    Toast.makeText(getApplicationContext(), "Kindly contact helpline. You may have contracted Covid-19", Toast.LENGTH_SHORT).show();
                }
                else { Toast.makeText(getApplicationContext(), "No symptoms of Covid-19. Please Consult your general physician", Toast.LENGTH_SHORT).show(); }
            }
        }
        else{ Toast.makeText(getApplicationContext(), "Enter valid input", Toast.LENGTH_SHORT).show();}


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

    }
}