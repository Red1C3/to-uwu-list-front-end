package com.reddeadalice.to_uwulist;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class RequestHandler {
    private RequestHandler() {

    }
    private static RequestHandler instance;
    private RequestQueue queue;
    public void init(Context ctx){
        queue= Volley.newRequestQueue(ctx);
    }
    public static RequestHandler getInstance(){
        if (instance==null) instance=new RequestHandler();
        return instance;
    }
    public void addRequest(JsonArrayRequest jsonArrayRequest){
        queue.add(jsonArrayRequest);
    }
    public void addRequest(JsonObjectRequest jsonObjectRequest){queue.add(jsonObjectRequest);}
}
