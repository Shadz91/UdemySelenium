package com.udemy.rahul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Dream11 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(
				"https://accounts.olacabs.com/?returnurl=https%3A%2F%2Fhelp.olacabs.com%2Fsupport%2Fmain&utm_source=ola_care_login");

		int number = findFrameNumber(driver, By.className("recaptcha-checkbox-checkmark"));
		System.out.println(number);
		driver.switchTo().frame(number); // 0
		driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();

		driver.switchTo().defaultContent();

		int number1 = findFrameNumber(driver, By.xpath("//*[text()='Verify']"));
		System.out.println(number1);
		driver.switchTo().frame(number1); // 1
		driver.findElement(By.xpath("//*[text()='Verify']")).click();
	}

	public static int findFrameNumber(WebDriver driver, By by) {
		int i;
		int frameCount = driver.findElements(By.tagName("iframe")).size();

		for (i = 0; i < frameCount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();
			driver.switchTo().defaultContent();
			if (count > 0) {
				break;
			}
		}

		driver.switchTo().defaultContent();
		return i;
	}
}