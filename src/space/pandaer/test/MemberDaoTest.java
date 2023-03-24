package space.pandaer.test;

import org.junit.jupiter.api.Test;
import space.pandaer.dao.MemberDao;
import space.pandaer.dao.impl.MemberDaoImpl;
import space.pandaer.entity.Member;

public class MemberDaoTest {
    private MemberDao memberDao = new MemberDaoImpl();
    @Test
    public void queryByUserName() {
        Member jack = memberDao.queryMemberByUsername("pandaer");
        System.out.println(jack);
    }

    @Test
    public void save(){
        Member pandaer = new Member(null, "pandaer", "1011", "100@qq.com");
        memberDao.saveMember(pandaer);
    }

    @Test
    public void testQueryUsernameAndPassword() {
        Member member = memberDao.queryMemberByNamePwd("liwenhaos", "111111");
        System.out.println(member);
    }



}
