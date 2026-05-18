package com.jocata.bank.dao;

import com.jocata.bank.entity.Account;
import com.jocata.bank.entity.Customer;
import com.jocata.bank.entity.Transactn;
import database.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements BankDao {

    public void saveUser(Customer customer){

        String sql="insert into Customer(cusName,cusAddress,cusPhone) values(?,?,?)";
        //Connection conn=null;

        try(Connection conn= DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if(conn==null){
                System.out.println("Failed to insert into Database....");
                return;
            }
            ps.setString(1,customer.getCusName());
            ps.setString(2,customer.getCusAddress());
            ps.setString(3,customer.getCusPhone());
            ps.executeUpdate();

            try(ResultSet rs=ps.getGeneratedKeys()){
                if(rs.next()){
                    customer.setCusId(rs.getInt(1));
                }
            }
            System.out.println("Successfully inserted into Database: "+customer.getCusName());
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }
    }

    public void updateUser(Customer customer){

        String sql = "UPDATE Customer SET cusName=?, cusAddress=?, cusPhone=? WHERE cusId=?";
        //PreparedStatement ps=null;

        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            if(conn==null){
                System.out.println("Failed to update into Database....");
                return;
            }
            ps.setString(1,customer.getCusName());
            ps.setString(2,customer.getCusAddress());
            ps.setString(3,customer.getCusPhone());
            ps.setInt(4,customer.getCusId());
            ps.executeUpdate();
            System.out.println("Successfully updated into Database: "+customer.getCusName());
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }
    }

    public void deleteUser(String cusName){
        String sql="delete from Customer where cusName=?";
        //PreparedStatement ps=null;

        try(Connection conn= DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);

            if(conn==null){
                System.out.println("Failed to delete from Database....");
                return;
            }
            ps.setString(1,cusName);
            ps.executeUpdate();
            System.out.println("Successfully deleted from Database: "+ cusName);
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }
    }

    public Customer findUser(String cusName){

        String sql="select * from Customer where cusName=?";
        //PreparedStatement ps=null;
        Customer customer=null;
        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            if(conn==null){
                System.out.println("Failed to fetch from Database....");
                return null;
            }
            ps.setString(1,cusName);
            try(ResultSet resultSet=ps.executeQuery()){
                if(resultSet.next()){
                    customer=new Customer();
                    customer.setCusId(resultSet.getInt("cusId"));
                    customer.setCusName(resultSet.getString("cusName"));
                    customer.setCusAddress(resultSet.getString("cusAddress"));
                    customer.setCusPhone(resultSet.getString("cusPhone"));

                }
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }
        return  customer;
    }

    public Account findAccount(int cusId){

        String sql="select * from Account where cusId=?";
        Account account=null;

        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);

            if(conn==null){
                System.out.println("Failed to fetch from Database....");
                return null;
            }

            ps.setInt(1,cusId);

            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    account=new Account();
                    account.setId(rs.getInt("id"));
                    account.setAccName(rs.getString("accName"));
                    account.setAccType(rs.getString("accType"));
                    account.setBalance(rs.getDouble("balance"));
                    account.setCusId(rs.getInt("cusId"));;
                    account.setStatus(rs.getString("status"));
                }
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }
        return  account;
    }

    public List<Transactn> findTransactn(int cusId){

        String sql="select * from Transactn where cusId=?";

        List<Transactn> transactn=new ArrayList<>();

        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, cusId);
            if(conn==null){
                System.out.println("Failed to fetch from Database....");
                return null;
            }
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    Transactn trans=new Transactn();
                    trans.setId(rs.getInt("id"));
                    trans.setCusId(rs.getInt("cusId"));
                    trans.setTransType(rs.getString("transType"));
                    trans.setAccNo(rs.getInt("accNo"));
                    trans.setAmount(rs.getInt("amount"));
                    transactn.add(trans);
                }

            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        return  transactn;
    }

    @Override
    public void updateBalance(int Id, double balance) {

        String sql="update Account set balance= ? where cusId=?";
        try(Connection conn=DataBaseConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, balance);
            ps.setInt(2, Id);
            ps.executeUpdate();
            System.out.println("Updated balance for Account ID " + Id + " to " + balance);

        } catch (SQLException e) {
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error....");
            e.printStackTrace();
        }

    }

    public void createTrans(Transactn transactn) {

        String sql="INSERT INTO Transactn(cusId, transType, amount, senderAcc, receiverAcc) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn=DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, transactn.getId());
            ps.setInt(1, transactn.getCusId());
            ps.setString(2, transactn.getTransType());
            //ps.setInt(4, transactn.getAccNo());
            ps.setDouble(3, transactn.getAmount());
            ps.setInt(4, transactn.getSenderAcc());
            ps.setInt(5, transactn.getReceiverAcc());
            ps.executeUpdate();
            System.out.println("Transaction created: " + transactn.getTransType() + " of " + transactn.getAmount());
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
    }

    public List<Transactn> findAllTrans(int cusId) {

        String sql="select * from Transactn where cusId=?";
        List<Transactn> transactn=new ArrayList<>();

        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,cusId);

            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    Transactn trans=new Transactn();
                    trans.setId(rs.getInt("id"));
                    trans.setCusId(rs.getInt("cusId"));
                    trans.setTransType(rs.getString("transType"));
                    trans.setAccNo(rs.getInt("accNo"));
                    trans.setAmount(rs.getInt("amount"));
                    trans.setSenderAcc(rs.getInt("senderAcc"));
                    trans.setReceiverAcc(rs.getInt("receiverAcc"));
                }
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        return  transactn;
    }

    public void createAccount(Account account) {
        String sql = "INSERT INTO Account (accName, accType, balance, cusId, status) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn=DataBaseConnection.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,account.getAccName());;
            ps.setString(2,account.getAccName());
            ps.setDouble(3,account.getBalance());;
            ps.setInt(4,account.getCusId());
            ps.setString(5,account.getStatus());
            ps.executeUpdate();
            try(ResultSet rs=ps.getGeneratedKeys()){
                if(rs.next()){
                    account.setId(rs.getInt(1));
                }
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
    }

    public boolean performTransaction(int senderAccountId, int receiverAccountId, double amount) {

        BankDao bankDao=new BankDaoImpl();

        Account sender = bankDao.findAccount(senderAccountId);
        Account receiver = bankDao.findAccount(receiverAccountId);

        if (sender == null || receiver == null) {
            System.out.println("Error: One or both accounts not found.");
            return false;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Error: Insufficient balance in sender account.");
            return false;
        }

        double newSenderBalance = sender.getBalance() - amount;
        double newReceiverBalance = receiver.getBalance() + amount;

        bankDao.updateBalance(senderAccountId, newSenderBalance);
        bankDao.updateBalance(receiverAccountId, newReceiverBalance);

        Transactn transaction = new Transactn();
        transaction.setCusId(sender.getCusId());
        transaction.setTransType("Transfer");

        transaction.setAmount(amount);
        transaction.setSenderAcc(senderAccountId);
        transaction.setReceiverAcc(receiverAccountId);
        bankDao.createTrans(transaction);

        System.out.println("Transaction successful! " + amount + " transferred from Account " + senderAccountId + " to Account " + receiverAccountId);
        return true;
    }

}
