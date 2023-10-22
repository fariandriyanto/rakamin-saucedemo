package SauceDemo.cucumber.stepdef;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("halaman login SauceDemo")
    public void halamanLoginSauceDemo(){

        driver = new ChromeDriver();
        //set timeout untuk chromeDriver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("klik tombol login")
    public void klikTombolLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user masuk ke dashboard")
    public void userMasukKeDashboard() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }

    @But("input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("123123");
    }

    @Then("user get error mesasge")
    public void userGetErrorMesasge() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals(loginPageAssert, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
