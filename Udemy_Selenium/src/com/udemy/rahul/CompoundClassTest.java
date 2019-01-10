package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompoundClassTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
	}

	@Test
	public void cssTest() throws InterruptedException {
		driver.findElement(By.cssSelector("input.input.r4.wide.mb16.mt8.username")).sendKeys("tagname.classname");
		driver.findElement(By.cssSelector(".input.r4.wide.mb16.mt8.password")).sendKeys(".classname");
		driver.findElement(By.cssSelector("[class='button r4 wide primary']")).click();
	}

	@Test
	public void xpathTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='input r4 wide mb16 mt8 username']")).sendKeys("hi");
		driver.findElement(By.xpath("//*[@class='input r4 wide mb16 mt8 password']")).sendKeys("bye");
		driver.findElement(By.xpath("//*[@class='button r4 wide primary']")).click();
	}

}
