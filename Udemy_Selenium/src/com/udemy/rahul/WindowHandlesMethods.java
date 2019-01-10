package com.udemy.rahul;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlesMethods {
	@Test
	public void WindowHandlesTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup");

		driver.findElement(By.xpath("//a[text()='Help']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println("Switched To Child Window: " + driver.getTitle()); // Important

		driver.switchTo().window(parentId);
		System.out.println("Switched Back To Parent Window: " + driver.getTitle()); // Important
	}
}