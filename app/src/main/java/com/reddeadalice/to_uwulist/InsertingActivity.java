package com.reddeadalice.to_uwulist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class InsertingActivity extends AppCompatActivity {
    private InputMethodManager imm;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);
        editText=(EditText)findViewById(R.id.note_box);
    }
    public void addNote(View view){
        String note=editText.getText().toString();
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("Note",note);
        } catch (JSONException exception) {
            Toast.makeText(this,"Invalid note",Toast.LENGTH_SHORT).show();
            return;
        }
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST,"http://" + MainActivity.HOST + ":" + MainActivity.PORT + "/add",jsonObject,
                response -> {
            startActivity(new Intent(this,MainActivity.class));
                },error -> {
            Toast.makeText(InsertingActivity.this,"Failed to send note",Toast.LENGTH_SHORT).show();
        });
        RequestHandler.getInstance().addRequest(request);
    }
}