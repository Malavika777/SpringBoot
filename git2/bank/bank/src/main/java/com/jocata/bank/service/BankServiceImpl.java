package com.jocata.bank.service;

import com.jocata.bank.bean.BankBean;
import com.jocata.bank.dao.BankDao;
import com.jocata.bank.dao.BankDaoImpl;
import com.jocata.bank.entity.Account;
import com.jocata.bank.entity.Customer;
import com.jocata.bank.entity.Transactn;

import java.util.List;

public class BankServiceImpl implements BankService {

    BankDao bankDao = new BankDaoImpl();

    public void saveUser(BankBean bankBean) {

        Customer cus=new Customer();
        cus.setCusName(bankBean.getCusName());
        cus.setCusPhone(bankBean.getCusPhone());
        cus.setCusAddress(bankBean.getCusAddress());
        bankDao.saveUser(cus);

        Customer saved=bankDao.findUser(bankBean.getCusName());
        if(saved!=null){
            System.out.println("Customer saved with ID :"+saved.getCusId());
            Account account=bankDao.findAccount(saved.getCusId());
            if(account!=null){
                System.out.println("Account details fetched :"+account);
            }
            else{
                System.out.println("Account details not found :"+saved.getCusId());
            }
        }
    }

    public void updateUser(BankBean bankBean) {
        Customer cus=bankDao.findUser(bankBean.getCusName());
        if(cus!=null) {
            cus.setCusPhone(bankBean.getCusPhone());
            cus.setCusAddress(bankBean.getCusAddress());
            bankDao.updateUser(cus);
        }
        else{
            System.out.println("Customer not found ");
        }
    }

    public void deleteUser(String cusName) {
        bankDao.deleteUser(cusName);
    }

    public Customer findUser(String cusName) {
        return bankDao.findUser(cusName);
    }

    public Account findAccount(int cusId) {
        return bankDao.findAccount(cusId);
    }

    public void createAccount(Account account) {
        ((BankDaoImpl) bankDao).createAccount(account);
    }


    public List<Transactn> findAllTrans(int cusId) {
        return bankDao.findAllTrans(cusId);
    }

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public boolean performTransaction(int senderAcc,int receiverAcc,double amount) {
        return bankDao.performTransaction(senderAcc,receiverAcc,amount);
    }
    public void updateBalance(int Id, double balance) {
        bankDao.updateBalance(Id, balance);
    }

    public void createTrans(Transactn transactn) {
        bankDao.createTrans(transactn);
    }

}
