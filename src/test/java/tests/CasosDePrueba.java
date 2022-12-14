package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    private JavascriptExecutor js;

    private String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String propertyDriver = "webdriver.chrome.driver";

    @AfterMethod
    public void posCondicion(){
        driver.close();
    }

    @BeforeMethod
    public void preCondiciones(){

        System.setProperty(propertyDriver,rutaDriver);

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);

        js = (JavascriptExecutor) driver;

        driver.navigate().to("https://open.spotify.com/");

        driver.manage().window().maximize();
    }

    @Test
    public void CP001_Registro_Fallido_Ausencia_De_Nombre() throws InterruptedException {
        System.setProperty(propertyDriver,rutaDriver);

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Regístrate')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("12345678aQ");

        driver.findElement(By.name("displayname")).sendKeys("");

        driver.findElement(By.id("day")).sendKeys("21");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("10");


        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));

        js.executeScript("arguments[0].scrollIntoView();", optionMale);


        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();

        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        btnRegistro.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(),"Introduce un nombre para tu perfil.");
    }
    @Test
    public void CP002_Registro_Fallido_Contraseña_En_Blanco() throws InterruptedException {
        System.setProperty(propertyDriver,rutaDriver);

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Regístrate')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("");

        driver.findElement(By.name("displayname")).sendKeys("Nacho");

        driver.findElement(By.id("day")).sendKeys("21");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("10");


        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));

        js.executeScript("arguments[0].scrollIntoView();", optionMale);


        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();

        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        btnRegistro.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(),"Debes introducir una contraseña.");
    }
    @Test
    public void CP003_Registro_Fallido_Dia_Invalido() throws InterruptedException {
        System.setProperty(propertyDriver,rutaDriver);

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Regístrate')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456aQ");

        driver.findElement(By.name("displayname")).sendKeys("Nacho");

        driver.findElement(By.id("day")).sendKeys("54");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("10");


        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));

        js.executeScript("arguments[0].scrollIntoView();", optionMale);


        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();

        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        btnRegistro.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(),"Indica un día del mes válido.");
    }
    @Test
    public void CP004_Registro_Fallido_Mes_Incompleto() throws InterruptedException {
        System.setProperty(propertyDriver,rutaDriver);

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Regístrate')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("ignacio.marrero@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456aQ");

        driver.findElement(By.name("displayname")).sendKeys("Nacho");

        driver.findElement(By.id("day")).sendKeys("10");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("");


        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));

        js.executeScript("arguments[0].scrollIntoView();", optionMale);


        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();

        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(),"Selecciona tu mes de nacimiento.");
    }
    @Test
    public void CP006_Boton_Iniciar_Sesion() throws InterruptedException {

        System.setProperty(propertyDriver, rutaDriver);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='login-button']"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='login-to-continue']")));

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='login-to-continue']")).getText(),"Para continuar, inicia sesión en Spotify.");
    }
}
