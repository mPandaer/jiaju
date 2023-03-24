package space.pandaer.dao.impl;

import space.pandaer.dao.BasicDAO;
import space.pandaer.dao.MemberDao;
import space.pandaer.entity.Member;

public class MemberDaoImpl extends BasicDAO<Member> implements MemberDao {

    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "select\n" +
                "    `id`,`username`,`password`,`email`,`role`\n" +
                "from member\n" +
                "where `username` = ?";
        return querySingle(sql, Member.class, username);
    }

    @Override
    public int saveMember(Member member) {
        String sql = "insert into member\n" +
                "    (`username`,`password`,`email`)\n" +
                "values\n" +
                "    (?,md5(?),?)";
        return update(sql,member.getUsername(),member.getPassword(),member.getEmail());
    }

    @Override
    public Member queryMemberByNamePwd(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`role`\n" +
                "from member\n" +
                "where `username`=? and `password`=md5(?)";
        return querySingle(sql,Member.class,username,password);
    }
}
