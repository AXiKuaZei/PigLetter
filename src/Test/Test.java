package Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    @org.junit.Test
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
}
