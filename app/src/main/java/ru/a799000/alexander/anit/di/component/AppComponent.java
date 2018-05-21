package ru.a799000.alexander.anit.di.component;


import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.alexander.anit.di.module.ApplicationModule;
import ru.a799000.alexander.anit.di.module.NavigationModule;
import ru.a799000.alexander.anit.di.module.RestModule;
import ru.a799000.alexander.anit.ui.activity.BaseActivity;

@Singleton
@Component(modules = {ApplicationModule.class, NavigationModule.class,RestModule.class})
public interface AppComponent {
    //activity
    void inject(BaseActivity baseActivity);

}
