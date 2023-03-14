package pages.samplepagetest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MassageSent {
    WebDriver driver;
    public MassageSent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//blockquote[@class='contact-form-submission']")
    WebElement savedTextForm;
    @FindBy(xpath = "//blockquote//p[1]")
    WebElement savedTextName;


    public String getTextForm(){
        return savedTextForm.getText();
    }
    public String getTextFormName(){
        return savedTextName.getText();
    }
}
