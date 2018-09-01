package dao;

import entity.UserInfo;
import entity.UserRel;
import entity.getCount;

import java.util.List;

public interface UserRelDao {
    List<getCount> getCountFans(int i);
    List<getCount> getCountAttention(int i);
}
