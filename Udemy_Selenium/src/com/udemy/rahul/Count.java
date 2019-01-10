package com.udemy.rahul;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Count {
	@Test
	public void linksTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Limiting WebDriver Scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// Limiting WebDriver Scope
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		List<WebElement> list = columnDriver.findElements(By.tagName("a"));

		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER); // Important
		for (int i = 1; i < list.size(); i++) {
			list.get(i).sendKeys(clickOnLink);
			Thread.sleep(10000);
		}

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}