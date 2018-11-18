package steps;

import org.junit.Assert;
import pages.InsurancePage;

public class InsuranceSteps {

    InsurancePage insurancePage = new InsurancePage();

    public void fillField(String name, String value) throws Exception {
        insurancePage.fillField(name, value);
    }

    public void checkField(String name, String value) throws Exception {
        Assert.assertEquals(value, insurancePage.getFiled(name).getAttribute("value"));
    }

    public void checkIsEnabled(String name) throws Exception {
        Assert.assertTrue("Кнопка - "+ name +" не активна", insurancePage.getFiled(name).isEnabled());
    }

    public void click(String name) throws Exception {
        insurancePage.click(name);
    }
}
