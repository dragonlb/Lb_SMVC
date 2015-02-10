package com.bc.db.dbUtils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
/**
 * 
 * MyBatis会话工厂类.
 * 
 * @version 1.0 2013-12-1
 * @author xqwu
 */
public class SessionFactoryUtil {
	
	protected static final Logger log = Logger.getLogger(SessionFactoryUtil.class);
	//MyBatis配置路径
	private static final String RESOURCE = "com/mybatis/config/Configuration.xml";
	//sql会话工厂
	private static SqlSessionFactory sqlSessionFactory = null;
	//所有sqlSession
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	/**
	 * 静态代码块 用于获得sqlSessionFactory
	 * 不执行 由SessionFactoryListener调用初始化方法
	 */
	/*static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException ioex) {
			throw new RuntimeException("Get resource error:"+RESOURCE, ioex);
		}
		//获得sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}*/
	
	/**
	 * 
	 * 获得SqlSessionFactory
	 * @author xqwu
	 * @date 2013-12-1 下午2:08:59
	 *
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory(){   
        return sqlSessionFactory;   
    }

	/**
	 * 
	 * 初始化SqlSessionFactory.
	 * @author xqwu
	 * @date 2013-12-1 下午2:08:39
	 *
	 */
	public static void initSqlSessionFactory() throws RuntimeException,Exception{
		try {
			
			if(sqlSessionFactory == null){
				Reader reader = Resources.getResourceAsReader(RESOURCE);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				log.debug("init sqlSessionFactory success");
			}
			
		} catch (IOException ioex) {
			
			throw new RuntimeException("Get resource error:"+RESOURCE, ioex);
			
		}
	}
	
	/**
	 * 
	 * 获取sqlSession.
	 * @author xqwu
	 * @date 2013-12-1 上午11:27:38
	 *
	 * @return
	 */
	public static SqlSession getSession(){
		SqlSession sqlsession = threadLocal.get();
		
		if(sqlsession!=null){
			if(sqlSessionFactory == null){
				getSqlSessionFactory();
			}
			//如果sqlSessionFactory不为空则获取sqlSession，否则返回null
			sqlsession = (sqlSessionFactory!=null) ? sqlSessionFactory.openSession(): null;
		}
		
		return sqlsession;
	}
	
	/**
	 * 
	 * 关闭sqlSession
	 * @author xqwu
	 * @date 2013-12-1 上午11:26:23
	 *
	 */
	public static void closeSqlSession() throws Exception{
		//获得sqlsession
		SqlSession sqlsession = threadLocal.get();
		threadLocal.set(null);
		if(sqlsession!=null){//验证关闭sqlsession
			sqlsession.close();
			log.debug("close sqlsession success");
		}
		
		log.debug("sqlsession is null");
	}
}
