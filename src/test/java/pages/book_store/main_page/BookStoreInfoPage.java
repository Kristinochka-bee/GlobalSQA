package pages.book_store.main_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.book_store.PageBase;

public class BookStoreInfoPage extends PageBase {
    public BookStoreInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='submit']")
    protected WebElement logOutButton;

    @FindBy(xpath = "//button[@id=\"addNewRecordButton\"]")
    protected WebElement backToBookStoreButton;

    @FindBy(xpath = "//button[@id=\"addNewRecordButton\"]")
    protected WebElement addToYourCollectionButton;

    @FindBy(xpath = "//div[@class='profile-wrapper']")
    protected WebElement booksInfoCard;

    @FindBy(xpath = "//label[@id=\"userName-value\"]")
    protected WebElement booksLink;

    public void clickOnBackToBookStoreButton(){
        backToBookStoreButton.click();
    }

    public void clickOnAddToYourCollectionButton(){
        addToYourCollectionButton.click();
    }

    public void clickOnWebLink(){
        click(booksLink);
    }

    public void clickOnLogOutButton(){
        logOutButton.click();
    }

    public String getTextForm(){
        return booksInfoCard.getText();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton(){
        driver.switchTo().alert().accept();
    }





}
