package pages.book_store;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);    //для аннотации FindBy, инициал элементы в нашем классе
    }

    public void click(WebElement element){
        element.click();
    }

    public void selectOption(String optionName, WebElement selectElement){
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionName);
    }
    public void fillField( WebElement field, String text) {
        click(field);
        field.clear();
        field.sendKeys(text);
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton(){
        driver.switchTo().alert().accept();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
