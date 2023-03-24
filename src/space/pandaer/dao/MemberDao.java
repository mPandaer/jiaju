package space.pandaer.dao;

import space.pandaer.entity.Member;

public interface MemberDao {
    
    //通过用户名查询
    Member queryMemberByUsername(String username);

    //保存用户  返回1表示成功 -1表示不成功
    int saveMember(Member member);

    //通过用户名和密码查询
    Member queryMemberByNamePwd(String username,String password);

}
