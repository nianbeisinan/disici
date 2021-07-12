package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类是 完成 客户 的所有业务（曾删改查）
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustome;
    //1.查，登录 判断账号密码 是否正确
    public void checkPwd(String cardid, String cardpwd) {
        CustomerData customerData =CustomerData .getInstance();
        customerList=customerData.getCustomerList();
        // 1. 拿到  cardid中的账户名 和 cardpwd  对  list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardpwd = " + cardpwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardpwd)){
                // 拿出来这个人
                currentCustome=customer;
                // 账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全");
                TextUtil.oneLeveOption();//界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
            }
                }
        }

    private void oneOption(String option) {
        switch (option) {
            case "1":
                System.out.println("余额查询");

                // 查询余额外
                doSelectMoney();
                // 当按下1 之后,  回退到  1及选项
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                goOneHome();
                break;
        }
    }
    // 查询余额
    private void doSelectMoney() {
        double money = currentCustome.getMoney();
        System.out.println(" 余额是 " +money);
    }

    private  void goOneHome( ){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  // 递归算法
    }


}


