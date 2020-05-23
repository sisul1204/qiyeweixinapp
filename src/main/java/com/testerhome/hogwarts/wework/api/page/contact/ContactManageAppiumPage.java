package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.driver.Driver;
import com.testerhome.hogwarts.wework.api.page.BasePage;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ContactManageAppiumPage extends BasePage {
    By 添加子部门= byText("添加子部门");

    @FindBy(xpath="xxxxxxxxx")
    @AndroidBy(xpath = "")
    @iOSFindBy(xpath="")
    WebElement 添加子部门2;
    By 添加成员=byText("添加成员");
    By 关闭=By.id("e2m");
    By 编辑框=By.id("b9k");


    public ContactManageAppiumPage(){
        PageFactory.initElements(
                new AppiumFieldDecorator(Driver.getInstance().appiumDriver, Duration.ofSeconds(15)),
                this
        );
        添加子部门2.click();
    }

    public ContactManageAppiumPage add(String name){
        click(添加子部门);
        sendKeys(编辑框,name);
        click("确定");
        return this;

    }

    public ContactPage back(){
        click(关闭);
        return new ContactPage();
    }


}
