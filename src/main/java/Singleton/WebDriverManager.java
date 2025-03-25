package Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {
    private static volatile WebDriverManager instance;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private WebDriverManager(){
    }

    public void initDriver(String browser, boolean headless){
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
                }
                webDriver.set(new ChromeDriver(chromeOptions));
                System.out.println("Chrome driver initialized" + (headless ? " in headless mode" : ""));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                webDriver.set(new FirefoxDriver(firefoxOptions));
                System.out.println("Firefox driver initialized" + (headless ? " in headless mode" : ""));
                break;

            default:
                throw new IllegalArgumentException("Invalid browser");
        }
    }

    public static void getInstance(String browser, boolean headless) {
        if (instance == null) {
            synchronized (WebDriverManager.class) {
                if (instance == null) {
                    instance = new WebDriverManager();
                    instance.initDriver(browser, headless);
                }
            }
        }
        if (webDriver.get() == null) {
            instance.initDriver(browser, headless);
        }
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
