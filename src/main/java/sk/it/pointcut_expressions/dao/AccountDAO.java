package sk.it.pointcut_expressions.dao;

import org.springframework.stereotype.Component;
import sk.it.pointcut_expressions.Account;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": method => AddAccount()");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": method => doWork()");
        return false;
    }
}
