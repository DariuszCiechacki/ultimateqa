package library.modules.automation.login;

import library.pages.courses.CollectionsPage;

public interface LoginInterface {
    CollectionsPage login(String email, String password);
    boolean isLoggedIn();
}
