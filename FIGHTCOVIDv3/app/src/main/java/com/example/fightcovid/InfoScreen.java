package com.example.fightcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InfoScreen extends AppCompatActivity {
    public void whoWebsite(View view){
        Uri uri = Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }
    public void aboutus(View view){
        Intent intent1 = new Intent(InfoScreen.this, AboutUs.class);
        startActivity(intent1);
    }
    public void backbtn7(View view){
        onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);
    }
}
