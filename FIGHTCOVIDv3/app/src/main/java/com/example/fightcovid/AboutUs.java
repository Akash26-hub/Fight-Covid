package com.example.fightcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    public void backbtn6(View view){
        onBackPressed();
    }
    public void dipafb(View view){
        Uri uri = Uri.parse("https://www.facebook.com/dipayan.ray.902");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }
    public void shubhafb(View view){
        Uri uri = Uri.parse("https://www.facebook.com/sorted.chakraborty/");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }
    public void akashfb(View view){
        Uri uri = Uri.parse("https://www.facebook.com/BatCow.26");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }
    public void ankitfb(View view){
        Uri uri = Uri.parse("https://www.facebook.com/ad13.in");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}
