package hh.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ChromeDriver driver;

    @FindBy(xpath = ".//span[@class='bloko-icon-dynamic']")
    private WebElement closeButton;

    @FindBy(xpath = ".//input[@class='bloko-button']")
    private  WebElement searchButton;

    public void clickCloseButton() {
       closeButton.click();
    }

    public  void clickSearchButton(){
        searchButton.click();
    }

    public void inputSectionSkils(String value) {
       //WebElement skilsField = driver.findElement(By.xpath(".//div[@class='line']/*/input"));
       WebElement skilsField = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(1)");
        skilsField.sendKeys(value);
    }

    public void inputSectionSalary(String value1,String value2 ) {
        WebElement skilsField = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(4)");
        skilsField.sendKeys(value1);
        skilsField = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(5)");
        skilsField.sendKeys(value2);
    }

    public void selectShowSalary(){
        Actions actions = new Actions(driver);
        WebElement element = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(6)");
        actions.moveToElement(element).click().build().perform();
    }
    public  void selectSectionExperience(){
        Actions actions = new Actions(driver);
        WebElement element = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(7)");
        actions.moveToElement(element).click().build().perform();
    }
}


