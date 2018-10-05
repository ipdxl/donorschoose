package com.altimetrik.donorschoose.ui.login;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public class LoginPresenterTest {

    @Test
    public void checkUsernameAndPasswordIsInCorrect() {
        LoginView loginView = Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("asdf", "secret");
        Mockito.verify(loginView).showErrorMessageForUserNamePassword();
    }

    @Test
    public void checkUsernameAndPasswordIsCorrect() {
        LoginView loginView = Mockito.mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("user1", "password");
        Mockito.verify(loginView).showLoginSuccessMessage();
    }
}