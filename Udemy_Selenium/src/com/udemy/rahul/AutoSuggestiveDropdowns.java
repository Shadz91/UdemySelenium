package com.udemy.rahul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class AutoSuggestiveDropdowns {
	@Test
	public void autoTest() throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/");

		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		Thread.sleep(5000);

		// Without JavascriptExecutor:
		// String compare =
		// driver.findElement(By.id("fromPlaceName")).getText();
		// System.out.println(compare);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById('fromPlaceName').value;"; // Only
																					// a
																					// String
		String text = (String) js.executeScript(script);

		int i = 0;
		while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")) {
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			i++;
			if (i > 10) {
				break;
			}
		}
		System.out.println("Found: " + text);
	}
}