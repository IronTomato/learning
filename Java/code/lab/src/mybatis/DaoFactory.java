package mybatis;

public class DaoFactory {
    
    public static CityDao getCityDao(MapperType mapperType){
        switch (mapperType) {
        case Xml:
            return new CityDaoImpl();
        case Annotation:
            return MyBatisUtil.getSession().getMapper(CityDao.class);
        }
        return null;
    }

    
    public enum MapperType{
        Xml,
        Annotation
    }
}
