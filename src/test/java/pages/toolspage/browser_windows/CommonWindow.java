package pages.toolspage.browser_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.Set;

public class CommonWindow {
    WebDriver driver;

    public CommonWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //переход на другую страницу метод
    String originalWindow;

    public String getOriginalWindow(){  //get Id главного окна
        return driver.getWindowHandle();
    }
    public void switchToNewTab(String originalWindow){
       // originalWindow = driver.getWindowHandle(); //узнаем айди ориг окна
        Set<String> handles = driver.getWindowHandles(); //записывает все окна в сет *уникальные значения хранит*, записывает id всех открытых окон
        for (String handle : handles){  //handle - новооткрытая вкладка, handles - все вкладки
            if (!originalWindow.equals(handle)){// если он не равен оригинальному окну, т е это значит, что мы нашли тот кот нам нужен
                driver.switchTo().window(handle); // переключаемся на тот, кот нам подошел
                break;
            }
        }
    }

    //закрывает новооткрытую вкладку и переключ на оригинальное окно
    public void closeAndSwitchToOriginalWindow(String originalWindow){
        driver.close(); //закрывает вкладку
        driver.switchTo().window(originalWindow);
    }


}
