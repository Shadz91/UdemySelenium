package com.udemy.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FramesTest {
	@Test
	public void DragAndDropTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");

		System.out.println("Frame count : " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); // Important
		driver.findElement(By.id("draggable")).click();

		Actions builder = new Actions(driver);
		Action action = builder
				.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build();
		action.perform();
		driver.switchTo().defaultContent(); // Important
		driver.findElement(By.xpath("//*[text()='Accept']")) .click();
	}
}
