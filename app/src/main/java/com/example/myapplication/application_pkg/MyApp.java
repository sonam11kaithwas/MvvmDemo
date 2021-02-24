package com.example.myapplication.application_pkg;

import android.app.Application;

/**
 * Created by Sonam-11 on 28/8/20.
 */
public class MyApp extends Application {
    static private MyApp INSTANCE;

    static public MyApp getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MyApp();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
