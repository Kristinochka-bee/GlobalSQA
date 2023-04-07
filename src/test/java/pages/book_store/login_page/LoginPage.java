package pages.book_store.login_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.book_store.PageBase;
import tests.Wait;

public class LoginPage extends PageBase {
    Wait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@placeholder=\"UserName\"]")
    protected WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    protected WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login']")
    protected WebElement loginButton;


    @FindBy(xpath = "//button[@id=\"newUser\"]")
    protected WebElement newUserButton;

    public void waitForLoading(){  //ожидание загрузки страницы, проверка на видимость данного элемента
        wait = new Wait(driver);
        wait.forVisibility(userNameInput);
        wait.forVisibility(passwordInput);
    }

    public void fillUserNameFill(String name){
        fillField(userNameInput,name);
    }

    public void fillPasswordFill(String pass){
        fillField(passwordInput, pass);
    }


    public void clickOnloginButton() {
        loginButton.click();
    }

    public void clickOnNewUserButton() {
        newUserButton.click();
    }
}
