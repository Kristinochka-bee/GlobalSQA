package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.samplepagetest.SamplePage;

public class SamplePageTest extends TestBase{
    SamplePage samplePage;

    Faker faker = new Faker();

    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String website = faker.internet().ipV4Address();

    String comment = faker.lorem().characters();
    String allertMessage = "Do you really fill rest of the form?";


    @Test
    public void samplePageTest() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.fillData(name, email, website);
        samplePage.selectValue("1-3");
        samplePage.choiceValueDatainCheckBox();
        Thread.sleep(1000);
        samplePage.choiceValueDataInRadioBox();
        samplePage.commentaryFill(comment);
        samplePage.clickAlertBox();
        Assert.assertEquals(samplePage.getAlertText(), allertMessage);
        samplePage.clickAlertOkButton();


    }
}
