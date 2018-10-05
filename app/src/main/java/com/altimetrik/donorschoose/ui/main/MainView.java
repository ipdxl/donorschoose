package com.altimetrik.donorschoose.ui.main;

import com.altimetrik.donorschoose.data.Proposal;
import com.altimetrik.donorschoose.ui.IBaseView;

import java.util.List;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
interface MainView extends IBaseView {
    void showResults(List<Proposal> proposals);
}
