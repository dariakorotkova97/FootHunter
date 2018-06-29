
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;



public class SearchBase {

    public static InputForm inputForm;
    public static Resume searchPage;
    public static ChromeOptions options;
    public static ChromeDriver chromeDriver;


    public static void searchData() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);
        inputForm = new InputForm(chromeDriver);
        searchPage = new Resume(chromeDriver);
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.get("https://hh.ru/search/resume/advanced");

        inputForm.clickCloseButton();
        inputForm.inputSectionSkils(JPanelApp.TextSkils);
        System.out.println(JPanelApp.TextSkils);
        inputForm.inputSectionSalary(JPanelApp.from,JPanelApp.to);
        inputForm.selectShowSalary();
        inputForm.selectSectionExperience(JPanelApp.flag);
        inputForm.clickSearchButton();
       searchPage.getResume(JPanelApp.N);
    }

}

