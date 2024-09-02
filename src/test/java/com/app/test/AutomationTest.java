package com.app.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://try.vikunja.io/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();

		//Find the xpath and send the inputs to the fields.
		//For two character username it is giving error eg 'A1'
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//input[@id='username']"), 0));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("A19"); 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test99@vikunja.io");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("98765432");
		driver.findElement(By.xpath("//button[@id='register-submit']")).click();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[text()=' Overview']"), 0));
		driver.close();

	}

}
