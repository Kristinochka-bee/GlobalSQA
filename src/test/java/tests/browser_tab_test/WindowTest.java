package tests.browser_tab_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolspage.browser_windows.BrowserWindowsPage;
import pages.toolspage.browser_windows.new_tab_page.NewTabPage;
import tests.TestBase;

public class WindowTest extends TestBase {
    String url = "https://demoqa.com/browser-windows";
    String expectedNewTabText = "This is a sample page";
    String actualNewTabText;
    String expectedOriginalTabText = "Browser Windows";
    String actualOriginalTabText ;
    String originalWindow; //идентификатор оригинального окна
    BrowserWindowsPage browserWindowsPage;

    NewTabPage newTabPage;

    @BeforeMethod
    public void openUrl(){
        driver.get(url);
    }
    @Test
    public void newTabTest(){
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();   //здесь записываем в переменную id оригинального окна
        browserWindowsPage.clickToNewTabButton();
        browserWindowsPage.switchToNewTab(originalWindow); // переход на новую вкладку

        newTabPage = new NewTabPage(driver);
        actualNewTabText = newTabPage.getHeaderText();
        Assert.assertEquals(actualNewTabText, expectedNewTabText);
        newTabPage.closeAndSwitchToOriginalWindow(originalWindow);

        actualOriginalTabText = browserWindowsPage.getMainHeaderText();
        Assert.assertTrue(browserWindowsPage.isMainHeaderIsDisplayed());
        Assert.assertEquals(actualOriginalTabText, expectedOriginalTabText);


    }


}
