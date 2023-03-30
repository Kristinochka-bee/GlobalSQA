package tests.toolsqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.toolspage.TablePage;
import tests.TestBase;

import java.util.List;
import java.util.Map;

public class TableTest extends TestBase {
    TablePage tablePage;
    String url = "https://demoqa.com/webtables";

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String age = String.valueOf(faker.number().numberBetween(10, 100));
    String email = faker.internet().emailAddress();
    String salary = String.valueOf(faker.number().numberBetween(10000, 10000000));
    String department = faker.lorem().characters(1);

    @BeforeMethod
    public void openUrl (){driver.get(url);}

    @Test
    public void tableTest() {
        tablePage = new TablePage(driver);
        List<Map<String, String>> data = tablePage.getTableData();
        System.out.println(data);
        System.out.println(data.get(1).get("Age"));
    }

    @Test
    public void addAndSearchTableData(){
        tablePage = new TablePage(driver);
        tablePage.clickOnAddButton();
        tablePage.fillData(firstName, lastName, email, age, salary, department);
        tablePage.clickToSubmitButton();
        tablePage.fillSearchFill(firstName);

        List<Map<String, String>> data = tablePage.getTableData();
        Assert.assertEquals(data.get(0).get("First Name"), firstName);
        Assert.assertEquals(data.get(0).get("Last Name"), lastName);
        Assert.assertEquals(data.get(0).get("Age"), age);
        Assert.assertEquals(data.get(0).get("Email"), email);
        Assert.assertEquals(data.get(0).get("Salary"), salary);
        Assert.assertEquals(data.get(0).get("Department"), department);

    }
}
