package library.modules.automation.login;

import library.pages.courses.CollectionsPage;

public interface LoginInterface {
    CollectionsPage enterSignInCredentials(String email, String password);
    boolean isLoggedIn();
}
