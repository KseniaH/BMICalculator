import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest2 {

    @Test
    public void checkStarvationCategory() {

        // Установить системную переменную
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        // Открыть браузер
        WebDriver driver = new ChromeDriver();

        // Открыть https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator");

        // Ввести вес

        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("45");

        // Ввести рост

        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("175");

        // Нажать кнопку Calculate
        WebElement calculateButton = driver.findElement(By.name("cc"));
        calculateButton.click();

        // Проверить, что категория Starvation
        WebElement categoryInput = driver.findElement(By.name("desc"));
        String actualCategory = categoryInput.getAttribute("value");

        assertEquals(actualCategory, "Your category is Starvation", "Category is not Starvation, should be Starvation");

        driver.quit();

    }
}
