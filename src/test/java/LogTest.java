import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class LogTest {

    @Test
    public void test(){
        String sql = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(sql);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            SqlSession ss = ssf.openSession();
//            List<Article> articleList = ss.getMapper(ArticleMapper.class).selectArticles();
//            User user = ss.getMapper(UserMapper.class).selectUserByName("root");
//            System.out.println(articleList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test12(){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("这是trace日志");
        logger.debug("这是trace日志");
        logger.info("这是trace日志");
        logger.warn("这是trace日志");
        logger.error("这是trace日志");


    }
}
