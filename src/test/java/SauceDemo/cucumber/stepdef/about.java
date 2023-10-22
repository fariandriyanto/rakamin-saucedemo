package SauceDemo.cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class about {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("masuk login")
    public void masuk_login(){

        driver = new ChromeDriver();
        //set timeout untuk chromeDriver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @When("user klik burger menu")
    public void userKlikBurgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user klik tombol about")
    public void userKlikTombolAbout() {
        driver.findElement(By.id("about_sidebar_link")).click();
    }

    @Then("menampilkan halaman about")
    public void menampilkanHalamanAbout() {

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[1]/div[1]/div/div[4]/div[1]/a/button")).getText();
        Assert.assertEquals(loginPageAssert, "Try it free");
        driver.close();
    }
}
