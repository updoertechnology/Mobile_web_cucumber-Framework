package com.utils;

import com.cucumber.listener.Reporter;
import com.utils.TestUtils;

import cucumber.api.Scenario;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.lang.model.element.Element;

public class GenericWrappers extends Base implements Wrappers, Wrappers.SelectDropDown{

	public Logger logger = Logger.getLogger(String.valueOf(GenericWrappers.class));
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static WebDriver driver1;
	protected static Configuration config = null;
	protected String appUrl;
	protected String clientUrl;
	protected String adminUrl;
	protected String partnerUrl;
	protected String clientEmailId;
	protected String clientEmailPassword;
	protected String adminId;
	protected String adminPassword;
	protected String partnerEmailPassword;
	protected String partnerEmailId;
	protected String deviceName;
	protected String platformVersion;
	protected String platformName;
	protected String appPackage;
	protected String appActivity;
	protected String udid;
	protected String partnerEmailId2;
	private String BrowserStackImpl;
	protected String BrowserStackMobileImpl;
	private String UserName;
	private String AccessKey;
	private String OS;
	private String Os_Version;
	private String Browser_Version;
	private String browser;
	public static int implicit=60;
	public static int  explicit=60;
	private Select select;

	public GenericWrappers() {


		ConfigurationFactory factory = new ConfigurationFactory("src/test/configFile/config.xml");
		try {
			config = factory.getConfiguration();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		clientUrl = config.getString("clientUrl");
		appUrl = config.getString("clientUrl");
		adminUrl = config.getString("adminUrl");
		partnerUrl = config.getString("partnerUrl");
		clientEmailId = config.getString("clientEmailId");
		clientEmailPassword = config.getString("clientEmailPassword");
		adminId = config.getString("adminId");
		adminPassword = config.getString("adminPassword");
		partnerEmailId = config.getString("partnerEmailId");
		partnerEmailId2 = config.getString("partnerEmailId2");
		partnerEmailPassword = config.getString("partnerEmailPassword");
		deviceName = config.getString("deviceName");
		platformVersion = config.getString("platformVersion");
		platformName = config.getString("platformName");
		appPackage = config.getString("appPackage");
		appActivity = config.getString("appActivity");
		udid = config.getString("udid");
		browser = config.getString("browser").toLowerCase();
		//   browser = System.getProperty("browser").toLowerCase();
		implicit = Integer.parseInt(config.getString("implicit").toLowerCase());
		explicit = Integer.parseInt(config.getString("explicit").toLowerCase());
		BrowserStackImpl = config.getString("BrowserStackImpl");
		BrowserStackMobileImpl = config.getString("BrowserStackMobileImpl");
		UserName = config.getString("UserName");
		AccessKey = config.getString("AccessKey");
		OS = config.getString("OS");
		Os_Version = config.getString("Os_Version");
		Browser_Version = config.getString("Browser_Version");
	}

	public void invokeApp(){

		launchWinBrowser();
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		setImplicit(implicit);
		getUrl(config.getString("clientUrl"));
	}


	public void refresh(){

		getDriver().navigate().refresh();
	}

	public String setUrl(String url){
		appUrl = url;
		if(appUrl.equalsIgnoreCase(Variable.DEV_URL)){
			appUrl = config.getString("url").replace("//", "//"+adminId+":"+adminPassword+"@");
		}else if(appUrl.equalsIgnoreCase(Variable.STAG_URL)){
			appUrl = appUrl = config.getString("url").replace("//", "//"+clientEmailId+":"+clientEmailPassword+"@");
		}
		return appUrl;
	}

	public void launchWinBrowser() {
		if (BrowserStackImpl.equalsIgnoreCase("true")) {
			if (browser.toLowerCase().equals(Variable.CHROME)) {
				  DesiredCapabilities caps = new DesiredCapabilities();
				    caps.setCapability("browserName", "chrome");
				    caps.setCapability("browser_version", "latest");
				    caps.setCapability("os", "Windows");
				    caps.setCapability("os_version", "10");
				    caps.setCapability("name", "parallel_test"); // test name
				    caps.setCapability("build", "browserstack-build-1"); // CI/CD job or build name
				    caps.setCapability("browserstack.debug", true);
				    try {
						 driver.set(new RemoteWebDriver(new URL("https://anubhavgangwar_c3X75G:BXh7j7jGsoKWRyyxmdxd@hub-cloud.browserstack.com/wd/hub"), caps));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				
				
//				System.out.println("browser name is : " + browser);
//				DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
//				desiredCapabilities.setBrowserName("chrome");
//				desiredCapabilities.setPlatform(Platform.WIN10);
//				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.merge(desiredCapabilities);
//				
//				try {
//					driver.set( new RemoteWebDriver(new URL("https://anubhavgangwar_c3X75:BXh7j7jGsoKWRyyxmdxd@hub-cloud.browserstack.com/wd/hub"),chromeOptions));
//					getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
//				}
//								DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
//								desiredCapabilities.setBrowserName("chrome");
//								desiredCapabilities.setPlatform(Platform.WIN8);
//								ChromeOptions chromeOptions = new ChromeOptions();
//								chromeOptions.merge(desiredCapabilities);
				//				try {
				//					driver.set(new RemoteWebDriver(new URL("http://10.50.20.246:4444/wd/hub"), new ChromeOptions()));
				//				} catch (MalformedURLException e) {
				//					e.printStackTrace();
				//				}
			} else if (browser.toLowerCase().equals(Variable.FIREFOX)){
				DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
				desiredCapabilities.setBrowserName("firefox");
				desiredCapabilities.setPlatform(Platform.WIN8);
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.merge(desiredCapabilities);
				try {
					driver.set(new RemoteWebDriver(new URL("http://10.50.20.246:4444/wd/hub"), new FirefoxOptions()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}

		} else if (BrowserStackImpl.equalsIgnoreCase("false")) {
			if (browser.toLowerCase().equals(Variable.CHROME)) {
				String osname = (System.getProperty("os.name"));
				if (isTextContain(osname, ("Mac"))) {
					WebDriverManager.chromedriver().setup();
					Map<String, Object> prefs = new HashMap<>();
					prefs.put("profile.default_content_setting_values.notifications", 2);
					prefs.put("download.default_directory", System.getProperty("user.dir")+"DemoAutomation/src/test/downloadedFolder");
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);

					driver.set(new ChromeDriver(options));

					//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
					//driver.set(new ChromeDriver());
				} else if (isTextContain(osname, ("Windows"))) {
					//WebDriverManager.chromedriver().setup();
					Map<String, Object> prefs = new HashMap<>();
					prefs.put("profile.default_content_setting_values.notifications", 2);
					prefs.put("download.default_directory", System.getProperty("user.dir")+"DemoAutomation/src/test/downloadedFolder");
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);

					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
					driver.set(new ChromeDriver(options));
				} else if (isTextContain(osname, ("Linux"))) {
					System.setProperty("webdriver.chrome.driver", "./driver/chromedriverlinux");
					driver.set(new ChromeDriver());
				}
			} else if (browser.toLowerCase().equals(Variable.FIREFOX)) {
				String osname = (System.getProperty("os.name"));
				if (isTextContain(osname, ("Mac"))) {
					System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
					driver.set(new FirefoxDriver());
				} else if (isTextContain(osname, ("Windows"))) {
					System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
					driver.set(new FirefoxDriver());
				} else if (isTextContain(osname, ("Linux"))) {
					System.setProperty("webdriver.gecko.driver", "./driver/geckodriverlinux");
					driver.set(new FirefoxDriver());
				}
			}
		}
	}

	public WebDriver getDriver(){

		return driver.get();
	}


	public void getUrl(String url){

		getDriver().navigate().to(url);
	}

	public void setImplicit(int timeOut){

		getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}


	public int setDefaultExplicit(){

		return Integer.parseInt("60");
	}

	public int setDefaultImplicit(){

		return Integer.parseInt("60");
	}

	public WebDriverWait webDriverWait(){

		return new WebDriverWait(getDriver(), explicit);
	}

	public WebDriverWait mobileDriverWait(){

		return new WebDriverWait(driver1, explicit);
	}


	public void quitBrowser() {

		getDriver().quit();
	}

	public void closeBrowser() {

		getDriver().close();
	}

	public void mouseOver(WebElement element) {

		waitVisibilityOfElement(element);
		new Actions(getDriver()).moveToElement(element).build().perform();
	}

	public void mouseOver(List<WebElement> element, int index) {

		waitVisibilityOfElement(element.get(index));
		new Actions(getDriver()).moveToElement(element.get(index)).build().perform();
	}

	public String getText(WebElement element){

		//        waitVisibilityOfElement(element);
		//        highLighterMethod(getDriver(), element);
		//scrollToElement(element);
		logger.info("Element Text - " + element.getText());
		return element.getText();
	}


	//    public String getText(By loc)
	//    {
	//        WebDriverWait wait = new WebDriverWait(this.driver, TimeSpan.FromSeconds(10));
	//        IWebElement el = wait.Until(ExpectedConditions.ElementIsVisible(loc));
	//        return el.Text;
	//    }

	public boolean isTextMatch(String actual, String expected) {

		logger.info("Actual Value - "+ actual + "\n" +"Expected Value - " + expected);
		return actual.equalsIgnoreCase(expected);
	}

	public boolean isElementTextMatch(WebElement actualElement, String expected){

		return isTextContain(getText(actualElement), expected);
	}

	public boolean isTextContain(String actual, String expected) {

		logger.info("Actual text - " + actual + "\n" + "Expected text - " + expected);
		return actual.contains(expected);
	}

	public void waitFor(int sleepTime){

		try {

			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


	public void clickButton(WebElement element) {
		scrollToElement(element);
		waitVisibilityOfElement(element);
		waitElementToBeClickable(element);
		element.click();
	}

	public void clickButtonWithOutScroll(WebElement element) {

		waitVisibilityOfElement(element);
		waitElementToBeClickable(element);
		highLighterMethod(getDriver(),element);
		element.click();
	}

	public void click(WebElement element){
		highLighterMethod(getDriver(),element);
		element.click();
	}

	public void scrollToTop() {

		JavascriptExecutor js =  (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollTo(0,0)");
		waitFor(1000);
	}

	public By locateXpath(String xpath){

		return By.xpath(xpath);
	}

	public By locateCss(String css){

		return By.cssSelector(css);
	}

	public void clickButton(WebElement scrollToElement, WebElement clickElement) {

		waitFor(1000);
		scrollToElement(scrollToElement);
		waitVisibilityOfElement(clickElement);
		waitElementToBeClickable(clickElement);
		clickElement.click();
	}

	public void clickDropDown(WebElement element, String xpath) {

		waitFor(1000);
		waitPresenceOfElementLocated(locateCss(xpath));
		element.click();
	}

	public void enterText(WebElement element, String ... textValue) {

		//scrollToElement(element);
		waitVisibilityOfElement(element);
		element.clear();
		logger.info("Entered Text - " + textValue);
		element.sendKeys(textValue);
	}

	public void enterTextWithoutScroll(WebElement element, String textValue) {

		waitVisibilityOfElement(element);
		element.clear();
		logger.info("Entered Text - " + textValue);
		element.sendKeys(textValue);
	}

	public void waitVisibilityOfElement(WebElement element) {

		webDriverWait().until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementToBeClickable(WebElement element) {

		webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitPresenceOfElementLocated(By by) {

		webDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void switchToParentWindow() {

		Set<String> winHandles = getDriver().getWindowHandles();
		for (String wHandle : winHandles) {
			getDriver().switchTo().window(wHandle);
			break;
		}
	}

	public void switchToLastWindow() {

		Set<String> winHandles = getDriver().getWindowHandles();
		for (String wHandle : winHandles) {

			getDriver().switchTo().window(wHandle);
		}
	}

	public void highLighterMethod(WebDriver driver, WebElement element){

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 2px solid blue;');", element);
	}

	public boolean isElementDisplayed(List<WebElement> elements) {

		return !elements.isEmpty();
	}

	public boolean isElementDisplayed(WebElement element){

		boolean flag;
		try {
			setImplicit(20);
			//			scrollToElement(element);
			highLighterMethod(getDriver(), element);
			element.isDisplayed();
			flag = true;
		}catch (Exception e){

			flag = false;
		}finally {

			setDefaultImplicit();
		}
		//logger.info("Is element " + element + " displayed - "+flag);
		return flag;
	}

	public boolean isElementDisplayedWithoutScroll(WebElement element){

		boolean flag;
		try {

			waitFor(1000);
			setImplicit(10);
			highLighterMethod(getDriver(), element);
			element.isDisplayed();
			flag = true;
		}catch (Exception e){

			setImplicit(implicit);
			flag = false;
		}
		logger.info("Is element " + element + " displayed - "+flag);
		return flag;
	}

	public boolean isElementEnabled(WebElement element){

		boolean flag;
		try {

			waitFor(1000);
			setImplicit(10);
			scrollToElement(element);
			highLighterMethod(getDriver(), element);
			element.isEnabled();
			flag = true;
		}catch (Exception e){

			setImplicit(implicit);
			flag = false;
		}
		logger.info("Is element " + element + " enabled - "+flag);
		return flag;
	}

	public boolean isEnabled(WebElement element){

		logger.info("Is element " + element + "enabled - "+element.isEnabled());
		return element.isEnabled();
	}

	public String getAttributeValue(WebElement element, String attributeName){

		waitVisibilityOfElement(element);
		logger.info("Attribute Value - "+element.getAttribute(attributeName));
		return element.getAttribute(attributeName);
	}

	public void takeSnap(io.cucumber.java.Scenario scenario) throws IOException {

		String scrname = scenario.getId().replace(";","").replace("-","");
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile,
				new File(getCurrentDir() + "/target/FailureScreenShots/" + scrname + ".png"));
		System.out.println(scrname+"Sce Nameashgdhjsbhbhbh123");
		System.out.println("inside screenshot");
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		Reporter.addScreenCaptureFromPath(
				"./FailureScreenShots/"+scrname+".png");
		// getDriver().quit();
	}

	public static String getCurrentDir(){

		String currentDir = System.getProperty("user.dir");
		currentDir = currentDir.replace('\\', '/');
		return currentDir;
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToMobileElement(WebElement element) {
		((JavascriptExecutor) driver1).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)", "");

	}

	public void scrollToPixel() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)", "");

	}

	public void scrollByPixelTop() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-400)", "");

	}



	public Select selectDropdown(WebElement element){

		select = new Select(element);
		return select;
	}

	public void selectByIndex(WebElement element, int index) {

		selectDropdown(element).selectByIndex(index);
	}

	public void SelectByValue(WebElement element, String value) {

		selectDropdown(element).selectByValue(value);
	}

	public void SelectByVisibleText(WebElement element, String text) {

		selectDropdown(element).selectByVisibleText(text);
	}

	public void waitForLoadIconDisappear(){

		webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oak-searchResults_preloader")));
	}

	public void waitForAriatLoadIconDisappear(){

		webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
	}

	public void waitForPaypalLoadIconDisappear(){

		webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'SpinnerOverlay_SpinnerOverlay')]")));
	}

	public boolean isVerifyTitleOfPage(String title){
		System.out.println(getDriver()+"TITLELLLLLLLLLLLLLLLLLLLL");
		setImplicit(5);
		logger.info("Actual -- "+getPageTitle()+" ||   Expected -- "+title);
		return getPageTitle().equalsIgnoreCase(title);
	}

	public String getPageTitle() {

		waitFor(2000);
		return getDriver().getTitle();
	}

	/****
	 * swipe element right or left by co-ordinated
	 * @param element
	 * @param offSet - (-1 swipe left or +1 swipe right)
	 */
	public void swipeByX(WebElement element, int offSet){

		Point point = element.getLocation();
		Actions actions = new Actions(getDriver());
		System.out.println("val: "+point.getX());
		actions.dragAndDropBy(element, point.getX()-offSet, point.getY()).build().perform();
	}
	public void swipeByXCoordinates(WebElement element, int offSet){

		Point point = element.getLocation();
		Actions actions = new Actions(getDriver());
		System.out.println("val: "+point.getX());
		actions.dragAndDropBy(element, offSet, point.getY()).build().perform();
	}

	public WebElement getXpathElement(String xpath){

		return getDriver().findElement(By.xpath(xpath));
	}

	public void switchToFirstFrame() {

		List<WebElement> frames = getDriver().findElements(By.xpath("//iframe"));
		getDriver().switchTo().frame(frames.get(0));

	}

	public void switchToFrameByIndex(int frameIndex) {
		List<WebElement> frames = getDriver().findElements(By.xpath("//iframe"));
		getDriver().switchTo().frame(frames.get(frameIndex));
	}

	public void switchToDefaultContent(){
		getDriver().switchTo().defaultContent();
	}

	public boolean swipeToDirection(WebElement element, Object object) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver1;
			HashMap<String, String> swipeObject = new HashMap<String, String>();
			if (object.equals("down")) {
				swipeObject.put("direction", "down");
			} else if (object.equals("up")) {
				swipeObject.put("direction", "up");
			} else if (object.equals("left")) {
				swipeObject.put("direction", "left");
			} else if (object.equals("right")) {
				swipeObject.put("direction", "right");
			}
			swipeObject.put("element", ((Scenario) element).getId());
			js.executeScript("mobile:swipe", swipeObject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public void switchingBetweenTabs(int tab) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
		System.out.println(tabs.size());
		getDriver().switchTo().window(tabs.get(tab));
		Thread.sleep(5000);
	}



	public void openNewTab(String url, int tab) throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.open()");
		Thread.sleep(10000); 
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
		int r = tabs.size();
		System.out.println(r);
		getDriver().switchTo().window( tabs.get(tab));
		getUrl(url);
	}

	public void uploadingFiles(WebElement element) throws InterruptedException, AWTException {
		// using linkText, to click on browse element 
		clickButton(element); // Click on browse option on the webpage
		Thread.sleep(2000); // suspending execution for specified time period

		// creating object of Robot class
		Robot rb = new Robot();
		String path =System.getProperty("user.dir")+"/src/test/configFile/upload.pdf";
		// copying File path to Clipboard
		//	    StringSelection str = new StringSelection("D:\\downloads\\DemoAutomation (4)\\DemoAutomation\\src\\test\\configFile\\upload.pdf");
		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);		
	}
	
	public void openApkFile() throws InterruptedException, MalformedURLException  {
		if (BrowserStackMobileImpl.equalsIgnoreCase("true")) {
			DesiredCapabilities caps = new DesiredCapabilities();
	    	
	    	// Set your access credentials
	    	caps.setCapability("browserstack.user", "anubhavgangwar_c3X75G");
	    	caps.setCapability("browserstack.key", "BXh7j7jGsoKWRyyxmdxd");
	    	
	    	// Set URL of the application under test
	    	caps.setCapability("app", "bs://a3a68360ecee98b73f0d3a16232fac6195b9e082");
	    	
	    	// Specify device and os_version for testing
	        caps.setCapability("device", "OnePlus 9");
	        caps.setCapability("os_version", "11.0");
	        
	    	// Set other BrowserStack capabilities
	    	caps.setCapability("project", "First Java Project");
	    	caps.setCapability("build", "browserstack-build-1");
	    	caps.setCapability("name", "first_test");
	    	
	       
	    	
	    	// Initialise the remote Webdriver using BrowserStack remote URL
	    	// and desired capabilities defined above
	        driver1 = new AndroidDriver<AndroidElement>(
	        		new URL("http://hub.browserstack.com/wd/hub"), caps);
	        
		} else if (BrowserStackImpl.equalsIgnoreCase("false")) {
			File app= new File(System.getProperty("user.dir")+"/src/test/resources/apps/HiFlow.apk");
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability("udid", udid);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("app", app.getAbsolutePath());
			driver1= new AndroidDriver(new ServerManager().getServer().getUrl(),capabilities);
			Thread.sleep(10000);
		}
			
		}
		
//
//	    }


//	public void openApkFile()throws InterruptedException, MalformedURLException {
//
//		File app= new File(System.getProperty("user.dir")+"/src/test/resources/apps/HiFlow.apk");
//		DesiredCapabilities capabilities= new DesiredCapabilities();
//		capabilities.setCapability("udid", udid);
//		capabilities.setCapability("appPackage", appPackage);
//		capabilities.setCapability("appActivity", appActivity);
//		capabilities.setCapability("deviceName", deviceName);
//		capabilities.setCapability("platformVersion", platformVersion);
//		capabilities.setCapability("platformName", platformName);
//		capabilities.setCapability("app", app.getAbsolutePath());
//		driver1= new AndroidDriver(new ServerManager().getServer().getUrl(),capabilities);
//		Thread.sleep(10000);
//
//	}

	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver1, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public Boolean isElementPresent(WebElement element) {
		waitForVisibility(element);
		return element.isDisplayed();
	}

	public void clickMobileButton(WebElement element) {
		scrollToMobileElement(element);
		waitForVisibility(element);
		isElementPresent(element);
		element.click();
	}


	public void swipeFromUpToBottom()
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver1;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe up was Successfully done.");
		}
		catch (Exception e){
			System.out.println("swipe up was not successfull");
		}
	}
	//Code to Swipe DOWN
	public void swipeFromBottomToUp()
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver1;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe down was Successfully done");
		}
		catch (Exception e)
		{
			System.out.println("swipe down was not successfull");
		}
	}

	public void swipeToSeeDownsideElementsOfScreen(int howManySwipes) {
		Dimension size = driver1.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.45);
		int endVerticalY = (int) (size.height * 0.25);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction((PerformsTouchActions) driver1).press(point(startVerticalX, startVerticalY))
				.waitAction(waitOptions(java.time.Duration.ofSeconds(2)))
				.moveTo(point(startVerticalX, endVerticalY)).release().perform();
				//FrameWorkLogger.log(LogType.INFO,"Swiped successfully  to see downside element of the screen");
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	public void swipeToSeeUpsideElementsOfScreen(int howManySwipes) {
		Dimension size = driver1.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction((PerformsTouchActions) driver1).press(point(startVerticalX, endVerticalY))
				.waitAction(waitOptions(java.time.Duration.ofSeconds(2)))
				.moveTo(point(startVerticalX, startVerticalY)).release().perform();
				//FrameWorkLogger.log(LogType.INFO,"Swiped successfully  to see upside element of the screen");
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	public void swipeToDownsideTillElementPresent(WebElement el, int maxswipe) throws InterruptedException {
		for(int i=1; i<=maxswipe;i++) {
			swipeToSeeDownsideElementsOfScreen(1);
			Thread.sleep(500);
			if(isElementPresent(el)) {
				break;
			}
		}
		System.out.println("Element Not Present After maximum number of swiping");
	}

	public void swipeToUpsideTillElementPresent(WebElement el, int maxswipe) throws InterruptedException {
		for(int i=1; i<=maxswipe;i++) {
			swipeToSeeUpsideElementsOfScreen(1);
			Thread.sleep(500);
			if(isElementPresent(el)) {
				break;
			}
		}
		System.out.println("Element Not Present After maximum number of swiping");
	}

	public void swipe(int startX, int startY, int endX, int endY, int millis)
			throws InterruptedException {
		new TouchAction((PerformsTouchActions) driver1).press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
		.perform();
	}

	public void clickAndroidDeviceBackBttn() {
		driver1.navigate().back();
	}
}
