package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.BasePage;
import org.openqa.selenium.By;

public class ContactManagePage extends BasePage {
    By 添加子部门= byText("添加子部门");
    By 添加成员=byText("添加成员");
    By 更多管理=byText("更多管理");
    By 删除部门=byText("删除部门");
    By 关闭=By.id("e2m");
    By 编辑框=By.id("b9k");

    public ContactManagePage add(String name){
        click(添加子部门);
        sendKeys(编辑框,name);
        click("确定");
        return this;

    }

    public ContactPage back(){
        click(关闭);
        return new ContactPage();
    }

    public ContactManagePage delete(){
        click(更多管理);
        click(删除部门);
        click(byText("确定"));
        return this;
    }

    public Boolean allowDelete(){
        click(更多管理);
        return findElements(删除部门).size()>0;
    }


}
