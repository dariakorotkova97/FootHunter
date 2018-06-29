import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
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
        JLabel[] labels = new JLabel[n];
        final String[] url = new String[n];
        JButton[] button = new JButton[n];
        int shiftYLabel=101, shiftYButton=101;
        for (int i=0; i<n; i++) {
            driver.get(st);
            resume = (List<WebElement>) ((JavascriptExecutor) driver)
                    .executeScript("return document.getElementsByClassName('search-item-name')");
            resume.get(i).click();
            labels[i]=new JLabel(resume.get(i).getText());
            labels[i].setBounds(40,20+shiftYLabel,400,30);

            shiftYLabel=shiftYLabel+50;
            JPanelAppResume.panelResume.add(labels[i]);

            url[i] = driver.getCurrentUrl();
            System.out.println(driver.getCurrentUrl());

            button[i]= new JButton("Перейти");
            button[i].setBounds(300,20+shiftYButton, 120, 25);
            shiftYButton=shiftYButton+50;
            JPanelAppResume.panelResume.add(button[i]);

           /* final int finali = i;
            button[i].addActionListener(new ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent ec) {
                   try {
                       Desktop.getDesktop().browse(java.net.URI.create(url[finali]));
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           });*/

       }



    }






}