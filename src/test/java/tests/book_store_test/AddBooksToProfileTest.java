package tests.book_store_test;

import org.testng.annotations.Test;
import pages.book_store.login_page.LoginPage;
import pages.book_store.login_page.new_user_page.NewUserPage;
import pages.book_store.login_page.profile_page.ProfilePage;
import pages.book_store.main_page.MainPage;
import tests.TestBase;

public class AddBooksToProfileTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    String userName = "harrypoter";
    String password = "A12345asd!";

    @Test
    public void loginExistingUserAndAddBooksToProfileAndDelete(){
        mainPage = new MainPage(driver);
        mainPage.waitForLoading();
        mainPage.clickOnLoginButton();

        loginPage = new LoginPage(driver);
        loginPage.waitForLoading();
        loginPage.fillUserNameFill(userName);
        loginPage.fillPasswordFill(password);
        loginPage.clickOnloginButton();

        profilePage = new ProfilePage(driver);
        profilePage.waitForLoading();
        profilePage.clickOnGoToStoreButton();
    }

}
