package hh.tests;

import hh.pages.SearchPage;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import hh.pages.MainPage;
import java.util.concurrent.TimeUnit;



public class FirstTest {
    public static MainPage mainPage;
    public static SearchPage searchPage;
    public static ChromeOptions options;
    public static ChromeDriver chromeDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);
        mainPage = new MainPage(chromeDriver);
        searchPage = new SearchPage(chromeDriver);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("https://hh.ru/search/resume/advanced");
    }

    @Test
     public void searchData() throws InterruptedException {
       mainPage.clickCloseButton();
       mainPage.inputSectionSkils("Системный администратор");
       mainPage.inputSectionSalary("30000","50000");
       mainPage.selectShowSalary();
       mainPage.selectSectionExperience();
       mainPage.clickSearchButton();
       searchPage.getResume();
    }



    @After
    public void afterTest(){
        //chromeDriver.quit();
    }
}
