package space.pandaer.service;

import space.pandaer.entity.Member;

public interface MemberService {

    //注册功能
    boolean registerMember(Member member);

    //检查用户是否存在
    boolean isExistMember(String username);

    //登录功能
    Member login(Member member);
}
