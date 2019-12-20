/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testautomationdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author tuana
 */
public class TestAutomationDemo {
private boolean flag = true; //to check the test status

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //lam nhung dieu ma user dung
        //viet code gia nguoi dung vao trinh duyet
        //Ta can bo thu vien ket noi voi Web Driver (.jar), dung jdbc de ket noi DB
        //Run
         //lauch the browser
        String exePath = "D:\\Google Drive\\Java Learning\\TestAutomationDemo\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();

        //connect to a website, load the 1st Page
        driver.get("http://toolsqa.com/automation-practice-form/");

        //maximize the browse
        driver.manage().window().maximize();
         //find an HTML element to get its data 
        //check if the 1st Page is loaded sucessfully
        WebElement pageHeaderElement = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));
        String header1 = pageHeaderElement.getText();
        if (!header1.equals("Automation Practice Form")) {
            System.out.println("Can't see the Form");
        }

        //assertEquals("Demo Form for practicing Selenium Automation", driver.getTitle());
        //click on Link Test
        driver.findElement(By.xpath("//a[@title='Automation Practice Table']")).click();
        //check if 2nd Page is loaded
        String header2 = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']")).getText();
        //or can use this statement: String header2 = pageHeaderElement.getText();

        if (!header2.equals("Automation Practice Table")) {
            System.out.println("Can't see the Table");
        }
    }
}
