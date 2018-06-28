
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;



public class SearchBase {

    public static InputForm mainPage;
    public static Resume searchPage;
    public static ChromeOptions options;
    public static ChromeDriver chromeDriver;


    public static void searchData() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        options = new ChromeOptions();
        //options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);
        mainPage = new InputForm(chromeDriver);
        searchPage = new Resume(chromeDriver);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("https://hh.ru/search/resume/advanced");

        mainPage.clickCloseButton();
        mainPage.inputSectionSkils(JPanelApp.TextSkils);
        System.out.println(JPanelApp.TextSkils);
        mainPage.inputSectionSalary(JPanelApp.from,JPanelApp.to);
        mainPage.selectShowSalary();
        mainPage.selectSectionExperience(JPanelApp.flag);
        mainPage.clickSearchButton();
        searchPage.getResume(JPanelApp.N);
    }

}

