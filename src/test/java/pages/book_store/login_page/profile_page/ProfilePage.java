package pages.book_store.login_page.profile_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.book_store.PageBase;
import tests.Wait;


public class ProfilePage extends PageBase {
    Wait wait;
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='text-center button']//button[@id='submit']")
    protected WebElement deleteAccountButton;

    public void waitForLoading(){  //ожидание загрузки страницы, проверка на видимость данного элемента
        wait = new Wait(driver);
        wait.forVisibility(deleteAccountButton);
    }
}
