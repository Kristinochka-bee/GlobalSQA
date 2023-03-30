package pages.toolspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TablePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@placeholder=\"Type to search\"]")
    protected WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"addNewRecordButton\"]")
    protected WebElement addButton;

    @FindBy(xpath = "//*[@id=\"delete-record-1\"]")
    protected WebElement deleteButton;

    @FindBy(xpath = "//input[@id=\"firstName\"]")
    protected WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"lastName\"]")
    protected WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"userEmail\"]")
    protected WebElement emailInput;

    @FindBy(xpath = "//input[@id=\"age\"]")
    protected WebElement ageInput;

    @FindBy(xpath = "//input[@id=\"salary\"]")
    protected WebElement salaryInput;

    @FindBy(xpath = "//input[@id=\"department\"]")
    protected WebElement departmentInput;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    protected WebElement submitButton;


    public void clickOnAddButton(){
        addButton.click();
    }

    public void clickToSubmitButton(){
        submitButton.click();
    }

    public void fillData(String firstName, String lastName, String email, String age, String salary, String department){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        emailInput.clear();
        emailInput.sendKeys(email);
        ageInput.clear();
        ageInput.sendKeys(age);
        salaryInput.clear();
        salaryInput.sendKeys(salary);
        departmentInput.clear();
        departmentInput.sendKeys(department);
    }

    public void fillSearchFill(String text){
        searchInput.clear();
        searchInput.sendKeys(text);
    }



    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Map<String,String>> getTableData(){
        List<WebElement> data = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        List<Map<String,String>> rows = new ArrayList<>();

        for (int i = 0; i <= data.size()-1; i++) {
            List<String> cell = new ArrayList<>();        //данные одной ячейки(строки) , кото потом будем помещать в Map
            Map<String,String> dataCell = new HashMap<>();
           // String dataString = data.get(i).getText();
            if (!data.get(i).getText().contains("   ")); //если в строке есть 3 пробела, это значит, что строка пустая
            for (int j = 1; j <= 6; j++) {
                String locator = String.format("//div[@role=\"rowgroup\"][%s]//div[@class='rt-td'][%s]", i + 1, j);  //локатор меняется от строки и столбца
                String cellText = driver.findElement(By.xpath(locator)).getText();
                cell.add(cellText);
            }
            dataCell.put("First Name", cell.get(0));
            dataCell.put("Last Name", cell.get(1));
            dataCell.put("Age", cell.get(2));
            dataCell.put("Email", cell.get(3));
            dataCell.put("Salary", cell.get(4));
            dataCell.put("Department", cell.get(5));
            rows.add(dataCell);
        }
        return rows;
    }
}
