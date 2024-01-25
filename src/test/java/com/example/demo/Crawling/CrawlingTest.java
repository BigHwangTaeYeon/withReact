package com.example.demo.Crawling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CrawlingTest {

    @Test
    void encryptTest() {
        // 1. WebDriver와 ChromeDriver 설정
        // 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 2. 웹 페이지 접속
//        String baseUrl = "https://movie.daum.net/ranking/boxoffice/weekly";
        String baseUrl = "https://www.google.co.kr/maps/search/%EC%84%9C%EC%9A%B8+%EB%96%A1%EB%B3%B6%EC%9D%B4/data=!4m2!2m1!6e5?entry=ttu";

        driver.get(baseUrl);

        // 3. 데이터 추출
        ArrayList<Movie> movie_data = new ArrayList<>();

//        WebElement movie_container = driver.findElement(By.cssSelector(".WNBkOb "));
        List<WebElement> movie_links = driver.findElements(By.cssSelector(".Nv2PK >a"));

        for(int i= 0; i < movie_links.size(); i++) {
            String link = movie_links.get(i).getAttribute("href");
            // links.add(link);
            driver.get(link);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            String title = driver.findElement(By.xpath("//*[@class=\"lMbq3e\"]/div/h1")).getText();
//            String start = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[1]/dd")).getText();
//            String star = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[2]/dl[1]/dd")).getText();
//            String learning_time = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[5]/dd")).getText();
//            String content = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[2]/div[1]/div/div/div")).getText();

            String start = "";
            String star = "";
            String learning_time = "";
            String content = "";

            Movie movie = new Movie(title, start, star, learning_time, content);

            System.out.println((i+1)+". "+ title + " (" + star + ")");

            movie_data.add(movie);

            driver.navigate().back();
            movie_links = driver.findElements(By.cssSelector(".Nv2PK >a"));
        }

        // 4. WebDriver 종료
        driver.quit();
    }

    @DisplayName("구글 타이틀 크롤링 성공")
    @Test
    void encryptTest2() {
        // 1. WebDriver와 ChromeDriver 설정
        // 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 2. 웹 페이지 접속
//        String baseUrl = "https://movie.daum.net/ranking/boxoffice/weekly";
        String baseUrl = "https://www.google.co.kr/maps/search/%EC%84%9C%EC%9A%B8+%EB%96%A1%EB%B3%B6%EC%9D%B4/data=!4m2!2m1!6e5?entry=ttu";

        driver.get(baseUrl);

        // 3. 데이터 추출
        ArrayList<Movie> movie_data = new ArrayList<>();

        List<WebElement> movie_links = movie_links = driver.findElements(By.cssSelector(".Nv2PK >a"));

        System.out.println("out for i size : " + movie_links.size());

        for(int i= 0; i < movie_links.size(); i++) {
            String link = movie_links.get(i).getAttribute("href");
            // links.add(link);
            driver.get(link);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            String title = driver.findElement(By.xpath("//*[@class=\"lMbq3e\"]/div/h1")).getText();
//            String start = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[1]/dd")).getText();
//            String star = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[2]/dl[1]/dd")).getText();
//            String learning_time = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[5]/dd")).getText();
//            String content = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[2]/div[1]/div/div/div")).getText();

            String start = "";
            String star = "";
            String learning_time = "";
            String content = "";

            Movie movie = new Movie(title, start, star, learning_time, content);

            System.out.println((i+1)+". "+ title + " (" + star + ")");

            movie_data.add(movie);

            driver.navigate().back();

            for(int y=0; y<20; y++) {
                driver.findElement(By.cssSelector(".w6VYqd > div > div > div > div > div > div > div")).sendKeys(Keys.PAGE_DOWN);
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            }
            movie_links = driver.findElements(By.cssSelector(".Nv2PK >a"));
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            System.out.println("list size : " + movie_links.size());
        }

        // 4. WebDriver 종료
        driver.quit();
    }

}
