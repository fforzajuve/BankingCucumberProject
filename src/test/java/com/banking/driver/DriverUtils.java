package com.banking.driver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.banking.utils.PropertiesUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils  implements WebDriver, JavascriptExecutor {
	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;

	public DriverUtils() {
		String browser = PropertiesUtil.getBrowserType();
//		MyLogger.getInstance().info("Browser: " + browser);
		initDriver(browser);
	}

	private void initDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		javascriptExecutor = (JavascriptExecutor) driver;
	}

	@Override
	public Object executeScript(String script, Object... args) {
		return javascriptExecutor.executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		return javascriptExecutor.executeAsyncScript(script, args);
	}

	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	public DriverUtils maximizeWindow() {
		driver.manage().window().maximize();
		return this;
	}

	public boolean isElementDisplayed(By by) {
		return driver.findElements(by).size() > 0;
	}

	public void waitForElementDisplayed(By by) {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void setTimeout(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void waitForAlertDisplayed() {
		(new WebDriverWait(driver, 2)).until(ExpectedConditions.alertIsPresent());
	}

	public void clickElementWithJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
