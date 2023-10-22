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

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user masuk ke halaman login")
    public void userMasukKeHalamanLogin(){

        driver = new ChromeDriver();
        //set timeout untuk chromeDriver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @When("user klik tombol add to cart")
    public void userKlikTombolAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }

    @And("user klik ikon keranjang")
    public void userKlikIkonKeranjang() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("user klik tombol checkout")
    public void userKlikTombolCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input data pelanggan")
    public void userInputDataPelanggan() {
        driver.findElement(By.id("first-name")).sendKeys("donni");
        driver.findElement(By.id("last-name")).sendKeys("muhaedi");
        driver.findElement(By.id("postal-code")).sendKeys("123123");
    }

    @And("user klik tombol continue")
    public void userKlikTombolContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user klik tombol finish")
    public void userKlikTombolFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("user klik tombol back to home")
    public void userKlikTombolBackToHome() {
        driver.findElement(By.id("back-to-products")).click();
    }

    @Then("berhasil checkout product")
    public void berhasilCheckoutProduct() {

        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }
}
