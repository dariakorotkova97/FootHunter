package logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HHResultResumePage;
import pages.HHSearchPage;
import interface_.InterfaceSearchPanel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class LogicSelenium {
    public static HHSearchPage inputForm;
    public static HHResultResumePage searchPage;
    public static ChromeOptions options;
    public static ChromeDriver chromeDriver;
    //public static  WebDriverWait wait;

    public static void findResume() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);
        inputForm = new HHSearchPage(chromeDriver);
        searchPage = new HHResultResumePage(chromeDriver);
        //wait = new WebDriverWait(chromeDriver,10);
        chromeDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        chromeDriver.get("https://hh.ru/search/resume/advanced");
        inputForm.clickCloseButton();
        inputForm.inputSectionSkils(InterfaceSearchPanel.textSkils);
        inputForm.inputSectionSalary(InterfaceSearchPanel.minWage, InterfaceSearchPanel.maxWage);
        inputForm.selectShowSalary();
        inputForm.selectSectionExperience(InterfaceSearchPanel.flag);
        inputForm.selectDecreasingSalary();
        inputForm.selectRegion("Россия");
        inputForm.clickSearchButton();
        searchPage.getResume(InterfaceSearchPanel.countResume);
    }

}

