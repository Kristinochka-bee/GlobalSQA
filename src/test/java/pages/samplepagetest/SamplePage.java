package pages.samplepagetest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SamplePage {
    WebDriver driver;


    public SamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//blockquote//p[1]")
    WebElement savedTextName;

    @FindBy(xpath = "//input[@name='file-553']")
    WebElement dataSelectButton;

    @FindBy(xpath = "//input[@id='g2599-name']")
    WebElement nameFill;

    @FindBy(xpath = "//input[@id='g2599-email']")
    WebElement emailFill;

    @FindBy(xpath = "//input[@id='g2599-website']")
    WebElement websiteFill;

    @FindBy(xpath = "//input[@value='Functional Testing']")
    WebElement fuctionalTestingCheckBox;

    @FindBy(xpath = "//label[normalize-space()='Automation Testing']")
    WebElement automationTestingCheckBox;

    @FindBy(xpath = "//input[@value='Manual Testing']")
    WebElement manualTestingCheckBox;

    @FindBy(xpath = "//input[@value='Graduate']")
    WebElement  graduateRadioButton;

    @FindBy(xpath = "//label[normalize-space()='Post Graduate']")
    WebElement  postGraduateRadioButton;

    @FindBy(xpath = "//input[@value='Other']")
    WebElement  otherRadioButton;

    @FindBy(xpath = "//textarea[@id='contact-form-comment-g2599-comment']")
    WebElement commentFill;

    @FindBy(xpath = "//button[normalize-space()='Alert Box : Click Here']")
    WebElement clickHereAlertBox;

    @FindBy(xpath = "(//button[normalize-space()='Submit'])[1]")
    WebElement submitButton;

    public void fillData(String name, String email, String website) {
        nameFill.clear();
        nameFill.sendKeys(name);
        emailFill.clear();
        emailFill.sendKeys(email);
        websiteFill.clear();
        websiteFill.sendKeys(website);
    }

    public void selectValue(String value) {
        Select select = new Select(driver.findElement(By.name("g2599-experienceinyears")));
        select.selectByVisibleText(value);
    }

    public void choiceValueDatainCheckBox(){
       fuctionalTestingCheckBox.click();
    }

    public void choiceValueDataInRadioBox(){
        otherRadioButton.click();
    }
    public void commentaryFill(String value){
        commentFill.sendKeys(value);
    }
    public void clickAlertBox(){
        clickHereAlertBox.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton(){
        driver.switchTo().alert().accept();
    }
}
