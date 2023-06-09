package tests;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    WebDriver driver;
    public WebDriverWait wait;
    Duration TIMEOUT = Duration.ofSeconds(10);

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait setWait() {
        wait = new WebDriverWait(driver, TIMEOUT);
        return wait;
    }

    public void forVisibility(WebElement element){    // элемент отображен в интерфейсе
        try {
            setWait().until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    public void forInvisibility(WebElement element){  //проверка, что элемент не виден , что он закрылось окно или  произошел переход на другую страницу
        try {
            setWait().until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }


}