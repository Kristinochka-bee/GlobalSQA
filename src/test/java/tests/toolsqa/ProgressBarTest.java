package tests.toolsqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolspage.ProgressBar;
import tests.TestBase;

public class ProgressBarTest extends TestBase {
    ProgressBar progressBar;
    String url = "https://demoqa.com/progress-bar";
    String percent = "37";
    String progressValue ;


    @BeforeMethod
    public  void precondition(){
        driver.get(url);
    }

    @Test
    public void setProgressBarTest(){
        progressBar = new ProgressBar(driver);
        progressBar.clickToStartStopButton();
        progressBar.clickToStop(percent);
        progressValue = progressBar.getAttributeValue(); //запишет значение атрибута в данную переменную
        Assert.assertEquals(progressValue,percent);
    }
}
