package tests.book_store_test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.book_store.login_page.LoginPage;
import pages.book_store.login_page.new_user_page.NewUserPage;
import pages.book_store.login_page.profile_page.ProfilePage;
import pages.book_store.main_page.MainPage;
import tests.TestBase;

public class AddNewUserTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    NewUserPage newUserPage;
    ProfilePage profilePage;
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userName = faker.name().username();
    String password = "A12345asd!";


    @Test
    public void addNewUserAndUserLogin(){
        mainPage = new MainPage(driver);
        mainPage.waitForLoading();
        mainPage.clickOnLoginButton();

        loginPage = new LoginPage(driver);
        loginPage.clickOnNewUserButton();

        newUserPage = new NewUserPage(driver);
        newUserPage.waitForLoading();
        newUserPage.fillNewUserForm(firstName,lastName,userName,password);
        newUserPage.clickRegisterButton();

        String expectedRegistrAlertText = "User Register Successfully.";
        String actualRegistrAlertText = newUserPage.getAlertText();
        Assert.assertTrue(actualRegistrAlertText.contains(expectedRegistrAlertText));
        newUserPage.clickAlertOkButton();

        newUserPage.clickBackToLoginButton();

        loginPage.fillUserNameFill(userName);
        loginPage.fillPasswordFill(password);
        loginPage.clickOnloginButton();

        profilePage = new ProfilePage(driver);
        profilePage.waitForLoading();

    }





}
