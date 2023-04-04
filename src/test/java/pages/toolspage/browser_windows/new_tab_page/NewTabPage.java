package pages.toolspage.browser_windows.new_tab_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.toolspage.browser_windows.CommonWindow;

public class NewTabPage extends CommonWindow {
    public NewTabPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    protected WebElement header;

    public String getHeaderText(){
        return header.getText();
    }
}
