package ru.a799000.alexander.anit.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;

import ru.a799000.alexander.anit.App;
import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.ui.fragment.base.BaseFragment;
import ru.a799000.alexander.anit.ui.navigate.NavigateManager;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.START_ACTION;

abstract public class BaseActivity extends MvpAppCompatActivity  {

    @Inject
    Router router;

    @Inject
    NavigatorHolder navigatorHolder;



    @Inject
    NavigateManager mNavigateManager;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getApplicationComponent().inject(this);

        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            mNavigateManager.getNavigator().applyCommands(new Command[]{new Replace(START_ACTION, 1)});
        }

    }

    public Router getRouter() {
        return router;
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(mNavigateManager.getNavigator());
    }


    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }



}
