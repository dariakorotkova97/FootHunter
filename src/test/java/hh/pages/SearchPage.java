package hh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage {

    public SearchPage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ChromeDriver driver;


    @FindBy(xpath = ".//div[@class='resume-search-item']")
    private List <WebElement> sections;

    public void getResume() throws InterruptedException {
        List<WebElement> resume = (List<WebElement>) ((JavascriptExecutor) driver)
        .executeScript("return document.getElementsByClassName('search-item-name')");
         String st=driver.getCurrentUrl();
        for (int i=0; i<3; i++) {
            driver.get(st);
            resume = (List<WebElement>) ((JavascriptExecutor) driver)
                    .executeScript("return document.getElementsByClassName('search-item-name')");
            System.out.println(resume.size());
            System.out.println(resume.get(i).getText());
            resume.get(i).click();
            System.out.println(driver.getCurrentUrl());

        }


        //int cats = maxitems.indexOf(Collections.max(maxitems));
        //WebElement search = driver.findElement(By.xpath("(.//div[@class='catalog-counts__more']/*/li/a)["+Integer.toString(cats+1)+"]"));
        //System.out.println(search.getText());
        //return search;
    }

   public WebElement getMaxItem() {
        List<Integer> maxitems= new ArrayList<Integer>();
        for (int i=1; i<5; i++){
            String st= sections.get(i).getAttribute("innerHTML");
            int item = Integer.parseInt(st.replaceAll("\\s+",""));
            maxitems.add(item);
        }
        int cats = maxitems.indexOf(Collections.max(maxitems));
        WebElement search = driver.findElement(By.xpath("(.//div[@class='catalog-counts__more']/*/li/a)["+Integer.toString(cats+1)+"]"));
        System.out.println(search.getText());
        return search;
    }

    public void clickMaxItem(){
        getMaxItem().click();
    }



 }