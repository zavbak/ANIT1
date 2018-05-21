package ru.a799000.alexander.anit.ui.navigate;

import android.support.v4.app.Fragment;
import android.widget.Toast;


import javax.inject.Inject;

import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.ui.activity.MainActivity;

import ru.a799000.alexander.anit.ui.fragment.ContractorsFeedFragment;
import ru.a799000.alexander.anit.ui.fragment.StartFragment;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.DETAIL_ACTION;
import static ru.a799000.alexander.anit.ui.navigate.MainActivityActions.START_ACTION;

public class NavigateManager {

    MainActivity mActivity;

    private Navigator mNavigator;

    @Inject
    public NavigateManager(MainActivity activity) {
        mActivity = activity;
        init();
    }


    public Navigator getNavigator() {
        return mNavigator;
    }


    private void init() {
        mNavigator = new SupportFragmentNavigator(mActivity.getSupportFragmentManager(), R.id.main_activity_container) {
            @Override
            protected Fragment createFragment(@MainActivityActions String screenKey, Object data) {
                switch (screenKey) {
                    case START_ACTION:
                        return StartFragment.getNewInstance();
                    case DETAIL_ACTION:
                        return ContractorsFeedFragment.getNewInstance();
                    default:
                        throw new RuntimeException("Unknown screen key!");
                }
            }

            @Override
            protected void forward(Forward command) {
                super.forward(command);
            }

            @Override
            protected void backTo(BackTo command) {
                super.backTo(command);
            }

            @Override
            protected void unknownScreen(Command command) {
                super.unknownScreen(command);
            }

            @Override
            public void applyCommands(Command[] commands) {
                super.applyCommands(commands);
                mActivity.getSupportFragmentManager().executePendingTransactions();
            }

            @Override
            protected void showSystemMessage(String message) {
                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void exit() {
                mActivity.finish();
            }
        };
    }


}
