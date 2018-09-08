package impl;

import dao.CountAADao;
import entity.CountAA;
import util.BaseDao;

import java.util.List;

public class CountAADaoImpl extends BaseDao<CountAA> implements CountAADao {
  @Override
  public List<CountAA> CountAA() {
    return executeQuery("select count(*) as AA from USER_INFO");
  }
}
