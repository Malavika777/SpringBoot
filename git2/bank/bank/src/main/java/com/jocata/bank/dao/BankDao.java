package com.jocata.bank.dao;

import com.jocata.bank.entity.Account;
import com.jocata.bank.entity.Customer;
import com.jocata.bank.entity.Transactn;

import java.util.List;

public interface BankDao {

    public void saveUser(Customer customer);
    public void updateUser(Customer customer);
    public void deleteUser(String cusName);
    Customer findUser(String cusName);
    Account findAccount(int cusId);
    public void updateBalance(int Id, double balance);
    public void createTrans(Transactn transactn);
    public void createAccount(Account account);
    List<Transactn> findAllTrans(int cusId);
    public boolean performTransaction(int senderAcc,int receiverAcc,double amount);

}
