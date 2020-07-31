package com.example.fightcovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;

public class NewsActivity extends AppCompatActivity {
    public void backbtn8(View view){
        onBackPressed();
    }
    private RequestQueue requestQueue;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        t1=(TextView) findViewById(R.id.textView11);

        String locality = getIntent().getStringExtra("data1");
        String state = getIntent().getStringExtra("data2");
        String city = getIntent().getStringExtra("data3");
        //Toast.makeText(getApplicationContext(), locality+"#"+state+"#"+city, Toast.LENGTH_SHORT).show();
        String data = "{\"state\":\""+ state +"\"}";
        Submit(data);
    }

    private void Submit(String data)
    {
        final String savedata= data;
        String URL="https://fightcovid.herokuapp.com/process";

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONParser parser = new JSONParser();
                    //JSONObject objres =new JSONObject(response);
                    JSONObject json = (JSONObject) parser.parse(response.toString());
                    //Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                    String confirmcase = (String) json.get("Confirmed Cases");
                    String cure = (String) json.get("Cured");
                    String deaths = (String) json.get("Deaths");
                    t1.setText("Confirmed Case: "+confirmcase+" Cured: "+cure+" Deaths: "+deaths);


                } catch (ParseException e) {

                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Please restart the app", Toast.LENGTH_SHORT).show();

                //Log.v("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    //Log.v("Unsupported Encoding while trying to get the bytes", data);
                    return null;
                }
            }

        };
        requestQueue.add(stringRequest);
    }
}
