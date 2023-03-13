package pages.samplepagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SamplePage {
    WebDriver driver;

    public SamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='file-553']")
    WebElement dataSelectButton;

    @FindBy(xpath = "//input[@id='g2599-name']")
    WebElement nameFill;

    @FindBy(xpath = "//input[@id='g2599-email']")
    WebElement emailFill;

    @FindBy(xpath = "//input[@id='g2599-website']")
    WebElement websiteFill;

    public void clickOnTheButton(By locator){
        Assert.assertTrue(dataSelectButton.isEnabled());
        driver.findElement(locator).click();
    }

    public void fillData(String name, String email, String website) {
        nameFill.clear();
        nameFill.sendKeys(name);
        emailFill.clear();
        emailFill.sendKeys(email);
        websiteFill.clear();
        websiteFill.sendKeys(website);
    }
}
