package com.tixon.a7evenfit.screens.new_diary_record_screen;

import javax.inject.Inject;

/**
 * Created by tikhon.osipov on 04.12.16
 */

public class NewDiaryRecordPresenter implements INewDiaryRecordPresenter {
    private INewDiaryRecordView view;

    @Inject
    public NewDiaryRecordPresenter(INewDiaryRecordView view) {
        this.view = view;
    }
}
