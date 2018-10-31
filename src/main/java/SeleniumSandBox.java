import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SeleniumSandBox {
    private static HashMap<String, WebDriver> driverPull = new HashMap<String, WebDriver>();

    public void startSelenium() {
        System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
        getDriver().get("file:///D:/0.html");
        maximizeBrowserWindow();
        getDriver().switchTo().frame(0);
        List<WebElement> tracks = getDriver().findElements(By.xpath(".//li[.//span[@class='track-description__artist']]//span[@class='track-description__name']"));
        List<WebElement> artists = getDriver().findElements(By.xpath(".//li[.//span[@class='track-description__name']]//span[@class='track-description__artist'][1]/.."));
        List<String> artStr = new ArrayList<String>();
        List<String> trStr = new ArrayList<String>();

        for (WebElement artist:
             artists) {
            artStr.add(artist.getAttribute("title"));
        }
        for (WebElement track:
                tracks) {
            trStr.add(track.getText());
        }
        for (int i=0;i<trStr.size(); i++){
            System.out.println(trStr.get(i) + " - " + artStr.get(i));
        }

        System.out.println("Page title is: " + getDriver().getTitle());
        (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println("Page title is: " + getDriver().getTitle());
        in();

        getDriver().quit();
    }

    private void in() {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
    }

    public void maximizeBrowserWindow() {
        getDriver().manage().window().maximize();
        for (int i = 0; i < 10; i++) {
            if (!((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                    .toString().equals("complete")) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;
        }
    }

    private static WebDriver getDriver() {
        String threadName = Thread.currentThread().getName();
        if (driverPull.get(threadName) == null) {
            driverPull.put(threadName, new ChromeDriver());
        }
        return driverPull.get(threadName);
    }
}
