package mybatis;

import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;

@FunctionalInterface
public interface SessionLoanee<R> extends Function<SqlSession, R>{

}
