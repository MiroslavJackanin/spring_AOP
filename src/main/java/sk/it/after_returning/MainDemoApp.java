package sk.it.after_returning;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.it.after_returning.dao.AccountDAO;
import sk.it.after_returning.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        account.setName("myAccount");
        account.setLevel("Platinum");

        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("FF_3026");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        membershipDAO.addMemberAccount();
        membershipDAO.goToSleep();

        context.close();
    }
}
