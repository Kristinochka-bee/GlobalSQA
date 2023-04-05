package pages.book_store.main_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.book_store.PageBase;
import tests.Wait;

public class MainPage extends PageBase {
    Wait wait;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@placeholder=\"Type to search\"]")
    protected WebElement searchInput;

    @FindBy(xpath = "//div[@role='grid']")
    protected WebElement booksTable;

    @FindBy(xpath = "//div[@id=\"login\"]")
    protected WebElement loginButton;

    @FindBy(xpath = "//button[@id='submit']")
    protected WebElement logOutButton;


    public void waitForLoading() {  //ожидание загрузки страницы, проверка на видимость данного элемента
        wait = new Wait(driver);
        wait.forVisibility(searchInput);
        wait.forVisibility(booksTable);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnLogOutButton(){
        logOutButton.click();
    }

    public void fillSeachInput(String text){
        fillField(searchInput, text);
    }
}