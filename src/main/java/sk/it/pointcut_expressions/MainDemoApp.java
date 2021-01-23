package sk.it.pointcut_expressions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.it.pointcut_expressions.dao.AccountDAO;
import sk.it.pointcut_expressions.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();

        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        membershipDAO.addMemberAccount();
        membershipDAO.goToSleep();

        context.close();
    }
}
