package pages.toolspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBar {
    WebDriver driver;

    public ProgressBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@role='progressbar']")
    protected WebElement progressBar;

    @FindBy(xpath = "//button[@id='startStopButton']")
    protected WebElement stopStartButton;

    private final String ATTRIBUTE_NAME = "aria-valuenow";

    public void clickToStartStopButton(){
        stopStartButton.click();
    }

    public String getAttributeValue(){
        return progressBar.getAttribute(ATTRIBUTE_NAME);
    }

    public void waitPercentExplicit(String percent){   //для нединамических проверок
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));
    }

    public void waitPercentFluent(String percent){   //для динамических проверок
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60)) //в течении 60 секунд
                .pollingEvery(Duration.ofNanos(2000000)) //осматривать страницу каждые 0,002 сек
                .until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));

    }

    public void clickToStop(String percent){
        //waitPercentExplicit(percent);
        waitPercentFluent(percent);
        clickToStartStopButton();
    }


}
