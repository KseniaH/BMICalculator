import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest4 {

    @Test
    public void checkSi() {

        // Установить системную переменную
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        // Открыть браузер
        WebDriver driver = new ChromeDriver();

        // Открыть https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator");

        // Ввести вес

        WebElement weightInput = driver.findElement(By.name("wg"));
        weightInput.sendKeys("60");

        // Ввести рост

        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("170");

        // Нажать кнопку Calculate
        WebElement calculateButton = driver.findElement(By.name("cc"));
        calculateButton.click();

        // Проверить значение SI

        WebElement siInput = driver.findElement(By.name("si"));
        String actualSi= siInput.getAttribute("value");
        String expectedSi = "20.76";
        assertEquals(actualSi, "20.76", "SI should be + expectedSi");

        driver.quit();

    }
}
