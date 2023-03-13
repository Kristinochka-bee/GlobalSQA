package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.samplepagetest.SamplePage;

public class SamplePageTest extends TestBase{
    SamplePage samplePage;

    Faker faker = new Faker();

    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String website = faker.internet().ipV4Address();

    @Test
    public void samplePageTest(){
        samplePage.clickOnTheButton(By.xpath("//input[@name='file-553']"));
        samplePage.fillData(name, email, website);
    }
}
