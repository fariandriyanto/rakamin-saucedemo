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

public class filter {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user ke halaman login")
    public void user_ke_halaman_login(){

        driver = new ChromeDriver();
        //set timeout untuk chromeDriver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @When("user klik tombol filter")
    public void userKlikTombolFilter() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
    }

    @And("user pilih filter price\\(low to high)")
    public void userPilihFilterPriceLowToHigh() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    }

    @Then("berhasil menerapkan filter")
    public void berhasilMenerapkanFilter() {
        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }
}
