package mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

public class TestMybatis {

    // @Test
    public void test() {
        String resource = "mybatis/mybatis.xml";

        SqlSession session = new SqlSessionFactoryBuilder()
                .build(this.getClass().getClassLoader().getResourceAsStream(resource)).openSession();
        String statement = "wnb.demo.mybatis.mapping.CityMapper.getCity";
        City city = session.selectOne(statement, 1);
        System.out.println(city);

        city.setId(5000);
        session.insert("wnb.demo.mybatis.mapping.CityMapper.addCity", city);
        city = session.selectOne(statement, 5000);
        System.out.println(city);
        session.commit();
        session.close();
    }

    @Test
    public void testAnnotation() {
        City city = MyBatisUtil.loanSession(session -> {
            CityDao dao = session.getMapper(CityDao.class);
            return dao.findById(2);
        });
        System.out.println(city);
    }

}
