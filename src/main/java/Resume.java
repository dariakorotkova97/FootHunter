import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resume {

    public Resume(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public static ChromeDriver driver;


    public static void getResume(int n) throws InterruptedException {
        List<WebElement> resume = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return document.getElementsByClassName('search-item-name')");
        String st=driver.getCurrentUrl();
        for (int i=0; i<n; i++) {
            driver.get(st);
            resume = (List<WebElement>) ((JavascriptExecutor) driver)
                    .executeScript("return document.getElementsByClassName('search-item-name')");
            System.out.println(resume.get(i).getText());
            resume.get(i).click();
            System.out.println(driver.getCurrentUrl());

        }
    }






}