package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DepartmentPage extends BasePage {
    By manage= By.id("e2j");
    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }

    public DepartmentPage gotoDepartment(String name){
        By departmentName= MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ name + "\").instance(0));");
        click(departmentName);
        return new DepartmentPage();
    }

    public List<String> getSubDepartmentNames(){
        List<String> array=new ArrayList<>();
        for(WebElement element: findElements (By.xpath("//*[contains(@resource-id,'akg')]/android.widget.TextView"))){
            array.add(element.getText());
        }

        return array;
    }

}
