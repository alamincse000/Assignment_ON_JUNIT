
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.*;


public class MyJunit {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void getTitle() {
        driver.get("https://demoqa.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("ToolsQA"));
    }

    @Test
    public void CheckBanner() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);
        driver.findElement(By.className("banner-image")).click();
//        wait = (WebDriverWait) driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//        driver.findElement(By.className("banner-image")).click();
    }

    @Test
    public void ClickElement() {
        driver.get("https://demoqa.com/elements");
        driver.findElement(By.className("header-wrapper")).click();
    }

    @Test
    public void WriteText() {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Alamin");
        driver.findElement(By.id("userEmail")).sendKeys("alamin@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur-2");
        driver.findElement(By.id("permanentAddress")).sendKeys("Rajbari");
        driver.findElement(By.id("submit")).submit();
    }

    @Test
    public void ClickMultipleElements() {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
//        WebElement doubleElements = driver.findElement(By.id("doubleClickBtn"));
//        actions.doubleClick(doubleElements).perform();
//
//        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
//        actions.contextClick(rightClick).perform();
//
//       String text1 = driver.findElement(By.id("doubleClickMessage")).getText();
//       String test2= driver.findElement(By.id("rightClickMessage")).getText();
//       Assert.assertTrue(text1.contains("You have done a double click"));
//       Assert.assertTrue(test2.contains("You have done a right click"));

        List<WebElement> list = driver.findElements(By.tagName("button"));
        actions.doubleClick(list.get(1)).perform();
        actions.contextClick(list.get(2)).perform();
        actions.click(list.get(3)).perform();

        String text1 = driver.findElement(By.id("doubleClickMessage")).getText();
        String test2 = driver.findElement(By.id("rightClickMessage")).getText();
        String text3 = driver.findElement(By.id("dynamicClickMessage")).getText();

        Assert.assertTrue(text1.contains("You have done a double click"));
        Assert.assertTrue(test2.contains("You have done a right click"));
        Assert.assertTrue(text3.contains("You have done a dynamic click"));
    }

    @Test
    public void HandleAlerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.id("promtButton")).click();

        driver.switchTo().alert().sendKeys("Alamin");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String getText = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(getText.contains("Alamin"));
    }

    @Test
    public void SelectDate() {
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).clear();
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("08/08/2022");
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);

    }

    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        Select color = new Select(driver.findElement(By.id("oldSelectMenu")));
        Thread.sleep(3000);
        color.selectByValue("2");


        WebElement ele =driver.findElement(By.id("cars"));
        Select cars =new Select(ele);
        cars.selectByIndex(0);
        cars.selectByValue("audi");
        cars.selectByValue("opel");
        Thread.sleep(3000);
        cars.deselectByIndex(0);

//        Another ways
//        for (cars.isMultiple());{
//            cars.selectByValue("volvo");
//            cars.selectByValue("audi");
//        }

    }

    @Test
    public void KeyBoardEvent() {
        driver.get("https://www.google.com/");
        WebElement webSearch = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.moveToElement(webSearch);
        actions.keyUp(Keys.SHIFT);
        actions.sendKeys("Selenium Webdriver")
                .keyUp(Keys.SHIFT)
                .doubleClick().click()
                .contextClick()
                .perform();


    }

    @Test
    public void MouseHover() throws InterruptedException {
        driver.get("https://green.edu.bd/");
        Actions actions = new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//a[contains(text(),\'About Us\')]"));
        Thread.sleep(5000);
        actions.moveToElement(list.get(2)).perform();
    }


    @Test
    public void screenShort() throws IOException {
        driver.get("https://green.edu.bd/");
        File schreenShrot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/schreenshorts/" + time + ".png";
        File DesFile = new File(fileWithPath);
        FileUtils.copyFile(schreenShrot, DesFile);

    }

    @Test
    public void tabHandle() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        ArrayList<String> w = new ArrayList(driver.getWindowHandles());
//switch to open tab
        driver.switchTo().window(w.get(1));
        System.out.println("New tab title: " + driver.getTitle());
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text, "This is a sample page");
        driver.close();
        driver.switchTo().window(w.get(0));
    }

    @Test
    public void windowsHandle() {
        driver.get("https://demoqa.com/browser-windows");

//Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
        driver.findElement(By.id(("windowButton"))).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String text = driver.findElement(By.id("sampleHeading")).getText();
                Assert.assertTrue(text.contains("This is a sample page"));
            }

        }
        driver.close();
    }

    @Test
    public void scrapData() {
        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.className("rt-tr"));
        int i = 0;
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.className("rt-td"));
            for (WebElement cell : cells) {
                i++;
                System.out.println("num[" + i + "] " + cell.getText());


            }

        }
    }

    @Test
    public void handleIframe() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame2");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertTrue(text.contains("This is a sample page"));
        driver.switchTo().defaultContent();
    }

    @Test
    public void UploadFile() {
        driver.get("https://demoqa.com/upload-download");
        wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
        element.sendKeys("D:\\orginal.jpg");
    }

    @Test
    public void Download() {
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
    }

    @After
    public void Finished() {
        driver.close();
        driver.quit();
    }
}
