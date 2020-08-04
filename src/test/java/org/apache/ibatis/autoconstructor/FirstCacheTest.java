package org.apache.ibatis.autoconstructor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author chenlong
 * 2020-08-04 23:42
 * 缓存
 */
public class FirstCacheTest {
  private SqlSessionFactory factory;
  private SqlSession session;

  @Before
  public void init() throws Exception {
    //获取构建器
    SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
    //解析XML工厂  并构建会话工厂
    factory = factoryBuilder.build(Executor.class.getResourceAsStream("org/apache/ibatis/autoconstructor/mybatis-config.xml"));
    session=factory.openSession();
  }

  @Test
  public void test(){
    AutoConstructorMapper mapper = session.getMapper(AutoConstructorMapper.class);
    PrimitiveSubject subject=mapper.getSubject(1);
    System.out.println(subject);
  }
}
