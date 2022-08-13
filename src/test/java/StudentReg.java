
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.HashMap;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class StudentReg {
    WebDriver driver;
    HashMap<String,String> hashMap=new HashMap<>();
    WebDriverWait wait;


    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void RegFrom() throws InterruptedException, IOException, ParseException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Alamin");
        driver.findElement(By.id("lastName")).sendKeys("Mondol");
        driver.findElement(By.id("userEmail")).sendKeys("alamin@gmail.com");

        driver.findElement(By.className("custom-control-label")).click();
//        driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
//        driver.findElement(By.xpath("//label[contains(text(),'Other')]")).click();
        driver.findElement(By.id("userNumber")).sendKeys("01741323634");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();

//        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).clear();
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).sendKeys("08 Aug 2022");
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadPicture")));
        element.sendKeys("D:\\orginal.jpg");

//        driver.findElement(By.id("uploadPicture")).sendKeys("D:\\orginal.jpg");

        driver.findElement(By.id("currentAddress")).sendKeys("Bashabo, Dhaka-1214");
        driver.findElement(By.id("submit")).submit();


        WebElement table= driver.findElement(By.tagName("tbody"));
        System.out.println(  table.isDisplayed());
//        System.out.println(driver.findElement(By.tagName("tbody")).isDisplayed());
        List<WebElement> allRows=table.findElements(By.tagName("tr"));
        System.out.println(allRows);
        for (WebElement row:
                allRows) {
            List<WebElement>cells=row.findElements(By.tagName("td"));

            hashMap.put(cells.get(0).getText(),cells.get(1).getText());
        }

        jsonDataWrite(hashMap);


    }
    public void jsonDataWrite(HashMap<String,String>userData) throws IOException, ParseException, ParseException {
        String fileName="./src/test/resources/students.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject userObj = new JSONObject();
        for (Map.Entry<String, String> set : userData.entrySet()) {
            userObj.put(set.getKey(), set.getValue());

        }

        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.add(userObj);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Saved!");
        System.out.print(jsonArray);

    }

    @After
    public void Finished() {
        driver.close();
        driver.quit();
    }
}


