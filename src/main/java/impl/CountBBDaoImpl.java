package impl;

import dao.CountBBDao;
import entity.CountBB;
import util.BaseDao;

import java.util.List;

public class CountBBDaoImpl extends BaseDao<CountBB> implements CountBBDao {
  @Override
  public List<CountBB> CountBB() {
    return executeQuery("select count(*) as BB from BLOG_CONTENT where report > 0");
  }
}
