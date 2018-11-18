package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import annotation.FieldName;
import util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


public class InsurancePage extends BasePageObject {

    public void fillField(String name, String value) throws Exception {
        WebElement element = getFiled(name);
        fillField(element, value);
    }

    public void click(String name) throws Exception {
        WebElement element = getFiled(name);
        click(element);
    }

    public WebElement getFiled(String name) throws Exception {
        Class example = Class.forName("ru.aplana.demo.pages.DepositPage");
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields){
            if (field.getAnnotation(FieldName.class).name().equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }
}
