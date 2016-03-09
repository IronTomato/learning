package mybatis;

public class CityDaoImpl implements CityDao {

    private static final String MAPPER_NAMESPACE = "mybatis.mappers.CityMapper";
    private static final String ADD_ID = MAPPER_NAMESPACE + ".add";
    private static final String SELECT_ID = MAPPER_NAMESPACE + ".select";
    private static final String DELETE_ID = MAPPER_NAMESPACE + ".delete";
    private static final String UPDATE_ID = MAPPER_NAMESPACE + ".update";

    @Override
    public int add(City city) {
        return MyBatisUtil.loanSession(s -> s.insert(ADD_ID, city));
    }

    @Override
    public City findById(int id) {
        return MyBatisUtil.loanSession(s -> s.selectOne(SELECT_ID, id));
    }

    @Override
    public int delete(int id) {
        return MyBatisUtil.loanSession(s -> s.delete(DELETE_ID, id));
    }

    @Override
    public int update(City city) {
        return MyBatisUtil.loanSession(s -> s.delete(UPDATE_ID, city));
    }

}
