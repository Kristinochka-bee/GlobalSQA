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

    @FindBy(xpath = "(//*[@class=\"main-header\"]")
    WebElement mainHeader;
    @FindBy(xpath = "//div[@class='text-center button']//button[@id='submit']")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElement goToStoreButton;

    @FindBy(xpath = "(//button[@id='submit'])[3]")
    WebElement deleteAllBooksButton;

    @FindBy(xpath = "//*[@placeholder=\"Type to search\"]")
    WebElement searchInput;

    @FindBy(xpath = "//span[@id=\"delete-record-undefined\"]")
    WebElement deleteIcon;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(goToStoreButton);
        wait.forVisibility(deleteIcon);
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }
    public void clickOnGoToStoreButton(){
        goToStoreButton.click();
    }

    public void clickOnDeleteAllBooksButton(){
        deleteAllBooksButton.click();
    }

    public void fillSearchFill(String nameOfBook){
        searchInput.sendKeys(nameOfBook);
    }
}
