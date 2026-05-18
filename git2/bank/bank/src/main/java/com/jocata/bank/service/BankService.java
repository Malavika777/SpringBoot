package com.jocata.bank.service;

import com.jocata.bank.bean.BankBean;
import com.jocata.bank.dao.BankDao;
import com.jocata.bank.entity.Account;
import com.jocata.bank.entity.Customer;
import com.jocata.bank.entity.Transactn;

import java.util.List;

public interface BankService {

    public void saveUser(BankBean bankBean);
    public void updateUser(BankBean bankBean);
    public void deleteUser(String cusName);
    Customer findUser(String cusName);
    Account findAccount(int cusId);
    public void updateBalance(int Id, double balance);
    public void createTrans(Transactn transactn);
    public List<Transactn> findAllTrans(int cusId);
    public void createAccount(Account account);
    public boolean performTransaction(int senderAcc,int receiverAcc,double amount);
    public void setBankDao(BankDao bankDao);
}
