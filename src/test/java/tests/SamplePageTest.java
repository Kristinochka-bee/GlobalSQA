package tests;

import com.github.javafaker.Faker;
import com.google.inject.spi.Message;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.samplepagetest.MassageSent;
import pages.samplepagetest.SamplePage;

public class SamplePageTest extends TestBase{
    SamplePage samplePage;
    MassageSent massageSent;

    Faker faker = new Faker();

    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String website = "https://www.globalsqa.com/samplepagetest/";

    String comment = faker.lorem().characters();
    String allertMessage = "Do you really fill rest of the form?";
    String allertGoodLuckMessage = "Good Luck. Go for it";


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
        Thread.sleep(1000);
        Assert.assertEquals(samplePage.getAlertText(), allertGoodLuckMessage);
        samplePage.clickAlertOkButton();
        Thread.sleep(5000);
        //samplePage.clickSubmitButton();

        massageSent = new MassageSent(driver);
        Thread.sleep(5000);

        Assert.assertTrue(massageSent.getTextForm().contains("Name: " + name));
        Assert.assertTrue(massageSent.getTextForm().contains("Email: " + email));
        Assert.assertTrue(massageSent.getTextForm().contains("Website: " + website));
        Assert.assertTrue(massageSent.getTextForm().contains("Experience (In Years): 1-3"));
        Assert.assertTrue(massageSent.getTextForm().contains("Expertise :: Functional Testing"));
        Assert.assertTrue(massageSent.getTextForm().contains("Education: Other"));
        Assert.assertTrue(massageSent.getTextForm().contains("Comment: " + comment));


        /*
        Assert.assertTrue(massageSent.getTextFormName().contains("Name: " + name));
        Assert.assertTrue(massageSent.getTextFormEmail().contains("Email: " + email));
         */


    }
}
