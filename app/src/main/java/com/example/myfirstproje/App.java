package com.example.myfirstproje;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.example.myfirstproje.data.remote.NetworkClient;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*Android networking*/
        AndroidNetworking.setParserFactory(new GsonParserFactory());
        AndroidNetworking.initialize(getApplicationContext(), NetworkClient.createClient());
    }
}
