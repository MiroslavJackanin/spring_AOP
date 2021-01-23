package sk.it.pointcut_expressions.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMemberAccount() {
        System.out.println(getClass() + ": method => addAccount()");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": method => goToSleep()");
    }
}
