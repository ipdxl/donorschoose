package com.altimetrik.donorschoose.ui.main;

import com.altimetrik.donorschoose.data.SearchFilter;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public class MainPresenterTest {


    @Test
    public void checkForMusicSearch() {
        MainView mainView = Mockito.mock(MainView.class);
        MainPresenter presenter = new MainPresenter(mainView);

        SearchFilter filter = new SearchFilter.Builder()
                .setSubject(-1)
//                .setAdditionalSubjects(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
//                .setLatLng(1.01234124123412, 0.1234123412341324)
                .create();
        presenter.setFilter(filter);
        presenter.doSearch();

        Assert.assertNotNull(presenter.getProposals());
        Assert.assertNotEquals(presenter.getTotalProposals(), 0);
    }

    @Test
    public void checkForEmptySearch() {

    }

    @Test
    public void checkForKeywordsSearch() {

    }

    @Test
    public void checkForSubjectSearch() {

    }

    @Test
    public void checkForLatLngSearch() {

    }

    @Test
    public void checkForNearestSearch() {

    }
}