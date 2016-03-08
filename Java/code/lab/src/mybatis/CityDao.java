package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface CityDao {

    @Insert("insert into city values(#{id},#{name},#{countryCode},#{district},#{population})")
    public int add(City city);
    
    @Select("select * from city where id=#{id}")
    public City findById(int id);
}
