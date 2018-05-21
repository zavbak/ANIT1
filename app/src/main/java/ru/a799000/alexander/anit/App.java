package ru.a799000.alexander.anit;


import android.app.Application;



import ru.a799000.alexander.anit.di.component.AppComponent;

import ru.a799000.alexander.anit.di.module.ApplicationModule;



public class App extends Application {

    private static AppComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
    }

    private void initComponent() {

        sApplicationComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static AppComponent getApplicationComponent() {
        return sApplicationComponent;
    }

}
