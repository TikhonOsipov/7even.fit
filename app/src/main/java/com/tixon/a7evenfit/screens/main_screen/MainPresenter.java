package com.tixon.a7evenfit.screens.main_screen;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 08.10.16
 */
public class MainPresenter implements IMainPresenter {
    IMainView view;

    @Inject
    public MainPresenter(IMainView view) {
        this.view = view;
    }
}
