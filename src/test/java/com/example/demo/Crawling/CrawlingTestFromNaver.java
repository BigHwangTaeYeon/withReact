package com.example.demo.Crawling;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CrawlingTestFromNaver {


//    @BeforeAll
//    static void setupAll() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeEach
    void setup() {
    }

    @AfterEach
    void teardown() {
    }


    @Test
    public void crawlFromNaver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 서울 떡볶이
        driver.get("https://map.naver.com/p/search/%EC%84%9C%EC%9A%B8%20%EB%96%A1%EB%B3%B6%EC%9D%B4");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        System.out.println("driver = " + driver.getTitle());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#searchIframe")));

        List<WebElement> elements = driver.findElements(By.cssSelector(".place_bluelink"));

        System.out.println("TestTest**********************************");
        System.out.println("elements.size() = " + elements.size());
//        elements.get(0).click();

        for(int i=2; i<elements.size(); i++){
            elements.get(i).click();

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.switchTo().defaultContent();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#entryIframe")));

            List<WebElement> placeSectionContents = driver.findElements(By.cssSelector(".place_section_content"));
            WebElement menuElement = placeSectionContents.get(placeSectionContents.size() - 1);
            List<WebElement> menus = menuElement.findElements(By.cssSelector("ul>li"));

            System.out.println("menumenu*******************************************");
            System.out.println("menus.size() = " + menus.size());

            for (WebElement menu : menus) {
                System.out.println(menu.getText());
            }

            driver.navigate().back();
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#searchIframe")));
            elements = driver.findElements(By.cssSelector(".place_bluelink"));
//            driver.switchTo().defaultContent();
//            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        }
        driver.quit();
    }

}
