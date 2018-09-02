package dao;

import entity.ShowMyInfo;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyInfoDao {
    List<ShowMyInfo> ShowMyInfo(BigDecimal myuserid);
}
