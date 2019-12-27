import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Logger log = Logger.getLogger(AutoSeleniumTest.class);
//        driver.get("http://www.baidu.com");
        driver.get("http://casualtypet.cccinfo.net/casualty/");
        driver.manage().window().maximize();
        log.info("输入用户名：auto01");
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("auto01");
        log.info("输入密码：1");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("打开任务");
        driver.findElement(By.xpath("//span[text() = 'TaskNo0814220685']")).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())

        {
            if (winHandle.equals(winHandleBefore))
            {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
 }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@id = 'insuredDriverDescription']")).clear();
        driver.findElement(By.xpath("//input[@id = 'insuredDriverDescription']")).sendKeys("Jenkins自动构建时已修改");
        driver.findElement(By.xpath("//a[@id = 'saveBtn']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[@id = 'confirmBtn']")).click();
        driver.close();
        driver.switchTo().window(winHandleBefore);
        driver.close();

//        WebElement searchInput = driver.findElement(By.xpath("//input[@id='kw']"));
//        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
//        if(searchInput.isDisplayed() && searchButton.isDisplayed())
//        {
//            System.out.println("搜索框无误，输入查询内容");
//            searchInput.sendKeys("俄罗斯");
//            searchButton.click();
//        }
//        else{
//            System.out.println("输入框无效，程序结束");
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.close();
    }
}
