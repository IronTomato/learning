package mybatis;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    
    private static SqlSessionFactory sessionFactory;
    
    static{
        sessionFactory = new SqlSessionFactoryBuilder().build(MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml"));
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
    
    public static <R> R loanSession(SessionLoanee<R> loanee){
        SqlSession session = getSession();
        try {
            R result = loanee.apply(session);
            session.commit();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
