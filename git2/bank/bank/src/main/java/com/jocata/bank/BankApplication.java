////package com.jocata.bank;
////
////import com.jocata.bank.bean.BankBean;
////import com.jocata.bank.dao.BankDaoImpl;
////import com.jocata.bank.entity.Customer;
////import com.jocata.bank.service.BankServiceImpl;
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////
////@SpringBootApplication
////public class BankApplication {
////
////	public static void main(String[] args) {
////
////        SpringApplication.run(BankApplication.class, args);
////
////        BankDaoImpl dao = new BankDaoImpl();
////        BankServiceImpl service = new BankServiceImpl();
////
////        BankBean bankBean = new BankBean();
////        bankBean.setCusName("Malavika");
////        bankBean.setCusAddress("Hyderabad");
////        bankBean.setCusPhone("1234567890");
////
////        System.out.println("1.CREATING CUSTOMER");
////        service.saveUser(bankBean);
////
////        System.out.println("2.Finding customer and their account details");
////        Customer foundCustomer = service.findUser("Malavika");
////        if (foundCustomer != null) {
////            System.out.println("Found Customer: " + foundCustomer);
////            System.out.println("Fetching account details for customer ID " + foundCustomer.getCusId());
////        } else {
////            System.out.println("Customer not found.");
////        }
////        System.out.println("3.Updating customer phone number");
////        bankBean.setCusPhone("9876543210");
////        service.updateUser(bankBean);
////
////        System.out.println("4.Verifying the update");
////        Customer updatedCustomer = service.findUser("Malu");
////        if (updatedCustomer != null) {
////            System.out.println("Updated Customer: " + updatedCustomer);
////        }
////
////
////	}
////
////}
//
//package com.jocata.bank;
//
//import com.jocata.bank.bean.BankBean;
//import com.jocata.bank.entity.Customer;
//import com.jocata.bank.service.BankServiceImpl;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class BankApplication {
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(BankApplication.class, args);
//
//        BankServiceImpl service = new BankServiceImpl();
//
//        // Data for the operations
//        BankBean testData = new BankBean();
//        testData.setCusName("Malavika");
//        testData.setCusAddress("Hyderabad");
//        testData.setCusPhone("1234567890");
//
//        // --- 1. CREATE OPERATION ---
//        System.out.println("1.CREATING CUSTOMER");
//        service.saveUser(testData);
//
//        // --- 2. READ OPERATION ---
//        System.out.println("2.Finding customer and their account details");
//        Customer foundCustomer = service.findUser("Malavika");
//        if (foundCustomer != null) {
//            System.out.println("Found Customer: " + foundCustomer);
//            System.out.println("Customer ID is: " + foundCustomer.getCusId());
//
//            // --- 3. UPDATE OPERATION ---
//            System.out.println("3.Updating customer phone number");
//            BankBean updateData = new BankBean();
//            updateData.setCusName("Malavika");
//            updateData.setCusPhone("9876543210");
//            updateData.setCusAddress("Bangalore");
//            service.updateUser(updateData);
//
//            // --- 4. READ (again) to verify update ---
//            System.out.println("4.Verifying the update");
//            Customer updatedCustomer = service.findUser("Malavika");
//            if (updatedCustomer != null) {
//                System.out.println("Updated Customer: " + updatedCustomer);
//            }
//        }
//    }
//}

package com.jocata.bank;

import com.jocata.bank.bean.BankBean;
import com.jocata.bank.dao.BankDao;
import com.jocata.bank.dao.BankDaoImpl;
import com.jocata.bank.entity.Account;
import com.jocata.bank.entity.Customer;
import com.jocata.bank.entity.Transactn;
import com.jocata.bank.service.BankServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {

        SpringApplication.run(BankApplication.class, args);

        BankServiceImpl service = new BankServiceImpl();
        BankDaoImpl dao = new BankDaoImpl();

        service .setBankDao(dao);

//        BankBean testData = new BankBean();
//        testData.setCusName("John");
//        testData.setCusAddress("Chennai");
//        testData.setCusPhone("1235567890");
//
//        System.out.println("\n--- 1. Creating a new customer ---");
//        service.saveUser(testData);
//
//        System.out.println("\n--- 2. Finding the customer and their account details ---");
//        Account acc=new Account();
//        Customer foundCustomer = service.findUser("Malavika");
//        if (foundCustomer != null) {
//            System.out.println("Found Customer: " + foundCustomer);
//
//            System.out.println("Fetching account details for customer ID " + foundCustomer.getCusId());
//
//            BankDaoImpl dao=new  BankDaoImpl();
//            Account account=dao.findAccount(foundCustomer.getCusId());
//            if (account != null) {
//                System.out.println("--- Account Details ---");
//                System.out.println("ID: " + account.getId());
//                System.out.println("Account Name: " + account.getAccName());
//                System.out.println("Account Type: " + account.getAccType());
//                System.out.println("Balance: " + account.getBalance());
//                System.out.println("Customer ID: " + account.getCusId());
//                System.out.println("Status: " + account.getStatus());
//                System.out.println("------------------------");
//            } else {
//                System.out.println("No account found for this customer.");
//            }
//
//            List<Transactn> transactions=dao.findTransactn(foundCustomer.getCusId());
//
//            if(!transactions.isEmpty()){
//                System.out.println("Found " + transactions.size() + " transaction(s):");
//                transactions.forEach(System.out::println);
//            }
//            else  {
//                System.out.println("No transactions found for this customer.");
//            }
//
//        } else {
//            System.out.println("Customer not found.");
//        }
//
//        System.out.println("3. Updating customer phone number ");
//        testData.setCusPhone("90111@@210");
//        service.updateUser(testData);
//
//        System.out.println("4. Verifying the update ");
//        Customer updatedCustomer = service.findUser("John");
//        if (updatedCustomer != null) {
//            System.out.println("Updated Customer: " + updatedCustomer);
//        }

//        System.out.println("5. Deleting the customer");
//        service.deleteUser("Malu");
//
//        System.out.println("6. Verifying deletion");
//        Customer deletedCustomer = service.findUser("Malu");
//        if (deletedCustomer == null) {
//            System.out.println("Customer was successfully deleted.");
//        } else {
//            System.out.println("Customer still exists.");
//        }

        System.out.println("Initializing .....");

        Customer customer1 = new Customer();
        customer1.setCusName("Malu"); customer1.setCusPhone("123"); customer1.setCusAddress("H");
        dao.saveUser(customer1);

        Account acc1 = new Account();
        acc1.setAccName("Savings"); acc1.setAccType("Savings"); acc1.setBalance(1000.0); acc1.setCusId(customer1.getCusId()); acc1.setStatus("Active");
        dao.createAccount(acc1);

        Customer customer2 = new Customer();
        customer2.setCusName("Joe"); customer2.setCusPhone("456"); customer2.setCusAddress("B");
        dao.saveUser(customer2);

        Account acc2 = new Account();
        acc2.setAccName("Savings"); acc2.setAccType("Savings"); acc2.setBalance(500); acc2.setCusId(customer2.getCusId()); acc2.setStatus("Active");
        dao.createAccount(acc2);

        System.out.println("Demo of Transaction");

        System.out.println("Initial Balance of Malu's Account (ID " + acc1.getId() + "): " + service.findAccount(acc1.getCusId()).getBalance());
        System.out.println("Initial Balance of Joe's Account (ID " + acc2.getId() + "): " + service.findAccount(acc2.getCusId()).getBalance());

        service.performTransaction(acc1.getCusId(), acc2.getCusId(), 200.0);

        System.out.println("Final Balance of Malu's Account (ID " + acc1.getId() + "): " + service.findAccount(acc1.getCusId()).getBalance());
        System.out.println("Final Balance of Joe's Account (ID " + acc2.getId() + "): " + service.findAccount(acc2.getCusId()).getBalance());

        // --- Clean up after the demo ---
//        System.out.println("\n--- Deleting demo data ---");
//        dao.deleteUser("Malu");
//        dao.deleteUser("Joe");


    }
}