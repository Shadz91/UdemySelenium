package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {
	@Test
	public void amazonTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList"));
		Actions builder = new Actions(driver);

		Action action = builder.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click()
				.keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).doubleClick().build();
		action.perform();

		Thread.sleep(5000);

		Action action1 = builder.moveToElement(element).contextClick().build();
		action1.perform();
	}
}