package ejemplosSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HolaMundoSelenium {
    public static void main(String[] args) throws InterruptedException {
        //Paso 1 Agregar el ChromeDriver (WebDriver)

        //Paso 2 - Enlazar el WebDriver
        String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Paso 3 - Instanciar un objeto de tipo ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Paso 4 Levanto el browser con la pag de google
        driver.get("https://www.google.com");

        //Paso 5 - Espero 5 segundos
        Thread.sleep(5000);

        //Paso 6 - Cerrar el Browser
        driver.quit();
    }
}
