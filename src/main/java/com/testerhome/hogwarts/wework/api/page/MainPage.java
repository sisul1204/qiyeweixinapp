package com.testerhome.hogwarts.wework.api.page;

import com.testerhome.hogwarts.wework.api.page.contact.ContactPage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By content= By.xpath("//*[@text='通讯录']");

    public ContactPage gotoContact(){
        click(content);
        return new ContactPage();
    }

    static MainPage mainPage;
    public static MainPage getInstance(){
        if(mainPage==null){
            mainPage=new MainPage();
        }
        return mainPage;
    }

}
