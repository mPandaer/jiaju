package space.pandaer.test;

import org.junit.jupiter.api.Test;
import space.pandaer.entity.Member;
import space.pandaer.service.MemberService;
import space.pandaer.service.impl.MemberServiceImpl;

public class MemberServiceTest {
    private final MemberService memberService = new MemberServiceImpl();

    @Test
    public void testIsExistMember(){
        boolean ans = memberService.isExistMember("pandaer");
        System.out.println(ans);
    }

    @Test
    public void testRegisterMember(){
        Member member = new Member(null, "pandaerx", "1111", "okhtt@qq.com");
        boolean ans = memberService.registerMember(member);
        System.out.println(ans);
    }

    @Test
    public void testLogin() {
        Member liwenhao = memberService.login(new Member(null, "liwenhao", "111111",null));
        System.out.println(liwenhao);
    }

}
