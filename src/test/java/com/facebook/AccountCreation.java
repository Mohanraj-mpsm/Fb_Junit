package com.facebook;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreation {
	
public static WebDriver driver;
public static WebDriverWait wait;
	
	@BeforeClass
	public static void launch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	}
		
	@AfterClass
	public static void close() {
		driver.quit();
	}

	@Test
	public void step1() {		
		driver.manage().window().maximize();		
	}
	
	
	@Test
	public void step2() {
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void step3() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement createAcc = driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Create new account')]")));
		createAcc.click();
	}
	
	@Test
	public void step4() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
		WebElement fname = driver.findElement(By.xpath("//input[@name='firstname']"));
		fname.click();
		fname.sendKeys("moh");
	
	}

	@Test
	public void step5() {
		WebElement sname = driver.findElement(By.xpath("//input[@name='lastname']"));
		sname.click();
		sname.sendKeys("mee");
	
	}
	
	@Test
	public void step6() {
		WebElement mob = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mob.click();
		mob.sendKeys("5267891526");
	
	}
	
	@Test
	public void step7() {
		WebElement pass = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		pass.click();
		pass.sendKeys("MeeMoh#1521");
		
	}
	
	@Test
	public void step8() {
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1996");
	
	}
	
	@Test
	public void step9() {
		WebElement gen = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		gen.click();
		
		WebElement signup = driver.findElement(By.xpath("//button[@name='websubmit']"));
		signup.click();
	
	}
	


}
