package space.pandaer.service.impl;

import space.pandaer.dao.MemberDao;
import space.pandaer.dao.impl.MemberDaoImpl;
import space.pandaer.entity.Member;
import space.pandaer.service.MemberService;
import space.pandaer.utils.MD5Utils;
import sun.security.provider.MD5;

import java.security.NoSuchAlgorithmException;

public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao = new MemberDaoImpl();


    @Override
    public boolean registerMember(Member member) {
        if (isExistMember(member.getUsername())) return false;
        return memberDao.saveMember(member) != -1;

    }

    @Override
    public boolean isExistMember(String username) {
        return memberDao.queryMemberByUsername(username) != null;
    }

    @Override
    public Member login(Member member) {
        if (member == null) return null;
        return memberDao.queryMemberByNamePwd(member.getUsername(),member.getPassword());
    }



}
