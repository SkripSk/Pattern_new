import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class InsuranceTest extends BaseTest{

    @Test
    public void testInsurance() {


        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();
        click(driver.findElement(By.xpath("//ul[@class='main-menu']//a[text()='Страхование']")));
        click(driver.findElement(By.xpath("//*[text()='В путешествие']/../../a")));
        click(driver.findElement(By.xpath("//a[text()='Оставить заявку'][@class='button']")));

        Assert.assertEquals("Форма заявки на страховую программу", driver.findElement(By.xpath("//h1[@class='e-title e-title--h2']")).getText());
        Assert.assertEquals("Вояж (Комфорт/Бизнес класс/Первый класс)", driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText());

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "12121992");
        testData.put("Телефон", "9101234567");
        testData.put("Электронная почта", "sdfsf@test.com");

        fillField(driver.findElement(By.xpath("//*[text()='Фамилия']/parent::div/input")), testData.get("Фамилия"));
        fillField(driver.findElement(By.xpath("//*[text()='Имя']/parent::div/input")), testData.get("Имя"));
        fillField(driver.findElement(By.xpath("//*[text()='Отчество']/parent::div/input")), testData.get("Отчество"));

        fillDate(driver.findElement(By.xpath("//div[@class='input-block input-calendar input-block--filled']/input")), testData.get("Дата рождения"));
        fillField(driver.findElement(By.xpath("//*[text()='Номер телефона'][@class='form-block__text form-label']/parent::div/input")), testData.get("Телефон"));
        fillField(driver.findElement(By.xpath("//*[text()='Электронная почта']/parent::div/input")), testData.get("Электронная почта"));




    }

    public void fillDate(WebElement element, String value){
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
        element.sendKeys(Keys.TAB);
    }


    public void acceptRegion() {
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }
}
