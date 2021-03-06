package ru.a799000.alexander.anit.ui.navigate;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.DETAIL_ACTION;
import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.START_ACTION;



@Retention(SOURCE)
@StringDef({
        START_ACTION,
        DETAIL_ACTION
})
public @interface MainActivityActions {
    String START_ACTION = "start";
    String DETAIL_ACTION = "detail";
}

