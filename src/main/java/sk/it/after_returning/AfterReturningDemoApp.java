package sk.it.after_returning;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.it.after_returning.dao.AccountDAO;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();
    }
}
