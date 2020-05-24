package com.testerhome.hogwarts.wework.api.page.contact;

import com.testerhome.hogwarts.wework.api.page.MainPage;
import com.testerhome.hogwarts.wework.api.testcase.AppTestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagePageTest extends AppTestCase {

    @BeforeAll
    static void beforeAllContactManagePageTest(){
        List<String> cleanData=new ArrayList<>();
        cleanData.add("demo6");

        //使用更好地办法清理数据  接口or数据库
        //todo:加个判断，如果没有
        try{
            for(String name:cleanData){
                DepartmentPage departmentPage=MainPage.getInstance().gotoContact().gotoDepartment(name);
                ContactManagePage contactManagePage=null;
                for(String sub:departmentPage.getSubDepartmentNames()){
                    contactManagePage=departmentPage.gotoDepartment(sub).gotoManage();
                    contactManagePage.delete();
                }
                if(contactManagePage==null){
                    departmentPage.gotoManage().delete();
                }

            }
        }catch (Exception e){
            System.out.println("not found");
            e.printStackTrace();
        } finally {

        }



    }

    @BeforeEach
    void beforeEach(){
        MainPage.getInstance().gotoMain();
    }






    @Test
    void delete(){
        //todo:滑动不稳定需要封装
        String departmentName="demo3";
        MainPage.getInstance()
                .gotoContact()
                .gotoManage().add(departmentName).back()
                .gotoDepartment(departmentName)
                .gotoManage().delete();
    }

    @Test
    void add() {
        String departmentName="demo3";
        String name=MainPage.getInstance().gotoContact().gotoManage().add(departmentName).back().getDepartment(departmentName);
        assertThat(name, equalTo(departmentName));
    }

    @Test
    void deleteWithChildren(){
        String departmentName="demo6";
        String subDepartmentName="demo7";
        Boolean result=MainPage.getInstance()
                .gotoContact()
                .gotoManage().add(departmentName).back()
                .gotoDepartment(departmentName)
                .gotoManage().add(subDepartmentName).back()
                .gotoManage().allowDelete();
        assertThat(result,equalTo(false));
    }


}