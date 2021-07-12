package com.hp.atm;

import com.hp.service.CustomerService;
import com.hp.util.TextUtil;

import java.util.Scanner;

public class AtmMain {

    private static String cardid;
    private static String cardpwd;
    private static CustomerService customerService;
    public static void main(String[] args) {
        customerService=new CustomerService();
     //测试 客户类的数据
       // CustomerData customerData =CustomerData .getInstance();
        //List<Customer> customerList=customerData.getCustomerList();
  /*      for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
   */  //welcome阶段
        TextUtil.welcome();
     // 输入账户密码阶段  

     //其他操作
       // 1.校验角色，2.判断账户密码的正确性
       int i=0;
        while (i<6){
            dowritePassword();
            doCheckPassword(cardid,cardpwd);
            i++;
        }
     
     //xxx
     

     //xxx   
        
    }
    //判断角色 和 判断密码
    private static void doCheckPassword(String cardid,String cardpwd) {
        // 1.校验角色,判断cardid的长度
        if (cardid.length() == 8) {//客户
            //校验密码
            customerService.checkPwd(cardid,cardpwd);
        }
        // 2.判断账户密码的正确性
    }

    //输入账号密码
    private static void dowritePassword() {
        System.out.println("请输入卡号");
        //得到一个标准的输入流，并创建一个基于输入流的对象
        Scanner scanner=new Scanner(System.in);
        //接收读取
        cardid = scanner.nextLine();
        System.out.println("cardid="+ cardid);
        System.out.println("请输入密码");
        cardpwd = scanner.nextLine();
        System.out.println("cardpwd="+ cardpwd);
    }


}

