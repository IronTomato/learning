package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface CityDao {

    @Insert("insert into city values(#{id},#{name},#{countryCode},#{district},#{population})")
    public int add(City city);
    
    @Select("select * from city where id=#{id}")
    public City findById(int id);
    
    
    @Delete("delete from city where id=#{id}")
    public int delete(int id);
    
    @Update("update city set name=#{name},countryCode=#{countryCode},district=#{district},population=#{population} where id=#{id}")
    public int update(City city);
}
