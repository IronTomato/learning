package mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import mybatis.DaoFactory.MapperType;

public class TestMybatis {

     @Test
    public void testMapper() {
        CityDao dao = DaoFactory.getCityDao(MapperType.Xml);
        
        City city = dao.findById(1);
        System.out.println(city);
        city.setId(5000);
        dao.add(city);
        System.out.println(dao.findById(5000));
        city.setName("wwwwwww");
        dao.update(city);
        System.out.println(dao.findById(5000));
        dao.delete(5000);
    }

    @Test
    public void testAnnotation() {
        CityDao dao = DaoFactory.getCityDao(MapperType.Annotation);
        
        City city = dao.findById(1);
        System.out.println(city);
        city.setId(5000);
        dao.add(city);
        System.out.println(dao.findById(5000));
        city.setName("wwwwwww");
        dao.update(city);
        System.out.println(dao.findById(5000));
        dao.delete(5000);
    }

}
