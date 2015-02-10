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
 * MyBatis�Ự������.
 * 
 * @version 1.0 2013-12-1
 * @author xqwu
 */
public class SessionFactoryUtil {
	
	protected static final Logger log = Logger.getLogger(SessionFactoryUtil.class);
	//MyBatis����·��
	private static final String RESOURCE = "com/mybatis/config/Configuration.xml";
	//sql�Ự����
	private static SqlSessionFactory sqlSessionFactory = null;
	//����sqlSession
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	/**
	 * ��̬����� ���ڻ��sqlSessionFactory
	 * ��ִ�� ��SessionFactoryListener���ó�ʼ������
	 */
	/*static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException ioex) {
			throw new RuntimeException("Get resource error:"+RESOURCE, ioex);
		}
		//���sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}*/
	
	/**
	 * 
	 * ���SqlSessionFactory
	 * @author xqwu
	 * @date 2013-12-1 ����2:08:59
	 *
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory(){   
        return sqlSessionFactory;   
    }

	/**
	 * 
	 * ��ʼ��SqlSessionFactory.
	 * @author xqwu
	 * @date 2013-12-1 ����2:08:39
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
	 * ��ȡsqlSession.
	 * @author xqwu
	 * @date 2013-12-1 ����11:27:38
	 *
	 * @return
	 */
	public static SqlSession getSession(){
		SqlSession sqlsession = threadLocal.get();
		
		if(sqlsession!=null){
			if(sqlSessionFactory == null){
				getSqlSessionFactory();
			}
			//���sqlSessionFactory��Ϊ�����ȡsqlSession�����򷵻�null
			sqlsession = (sqlSessionFactory!=null) ? sqlSessionFactory.openSession(): null;
		}
		
		return sqlsession;
	}
	
	/**
	 * 
	 * �ر�sqlSession
	 * @author xqwu
	 * @date 2013-12-1 ����11:26:23
	 *
	 */
	public static void closeSqlSession() throws Exception{
		//���sqlsession
		SqlSession sqlsession = threadLocal.get();
		threadLocal.set(null);
		if(sqlsession!=null){//��֤�ر�sqlsession
			sqlsession.close();
			log.debug("close sqlsession success");
		}
		
		log.debug("sqlsession is null");
	}
}
