package sk.it.ordering_aspects;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.it.ordering_aspects.dao.AccountDAO;
import sk.it.ordering_aspects.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();

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
