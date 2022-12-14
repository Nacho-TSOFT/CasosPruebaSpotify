package ejemplosSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MetodosNavegadorNavegacionSelenium {
    public static void main(String[] args) throws InterruptedException {

        String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println("Titulo pagina Google: "+ driver.getTitle());

        Thread.sleep(5000);

        //redireccionar a Spotify

        driver.navigate().to("https://open.spotify.com/");

        System.out.println("Titulo pagina Spotify: "+ driver.getTitle());

        System.out.println("url actual: "+driver.getCurrentUrl());

        System.out.println("--------------------------------------------------------------");

        System.out.println(driver.getPageSource());
        System.out.println("--------------------------------------------------------------");

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        driver.quit();
    }
}
