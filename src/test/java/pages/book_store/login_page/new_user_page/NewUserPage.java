package pages.book_store.login_page.new_user_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.book_store.PageBase;
import tests.Wait;

public class NewUserPage extends PageBase {
    Wait wait;
    public NewUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"userForm\"]")
    protected WebElement userForm;

    @FindBy(xpath = "//input[@placeholder=\"First Name\"]")
    protected WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"lastname\"]")
    protected WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"userName\"]")
    protected WebElement userNameInput;

    @FindBy(xpath = "//*[@placeholder=\"Password\"]")
    protected WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"register\"]")
    protected WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"gotologin\"]")
    protected WebElement backToLoginButton;

    @FindBy(xpath = "//body/div[@id='app']/div/div/div/div/div[2]")
    protected WebElement reCaptcha;


    public void waitForLoading(){  //ожидание загрузки страницы, проверка на видимость данного элемента
        wait = new Wait(driver);
        wait.forVisibility(userForm);
    }

    public void fillNewUserForm(String firstName, String lastName, String userName, String password){
        fillField(firstNameInput, firstName);
        fillField(lastNameInput, lastName);
        fillField(userNameInput, userName);
        fillField(passwordInput, password);
    }

    public void clickRegisterButton(){
       registerButton.click();
    }
    public void clickBackToLoginButton(){
        backToLoginButton.click();
    }
    public void verifyreCaptcha(){
        reCaptcha.submit();
    }

}
