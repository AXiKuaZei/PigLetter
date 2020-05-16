package cn.pigletter.dao;

import cn.pigletter.model.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ArticleMapper {
    //返回所有文章
    List<Article> selectArticles();

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);

    List<Article> selectArticlesPage(@Param("id") int id,@Param("size") int size);

    List<Article> selectArticlesPageUser(@Param("id") int id,@Param("size") int size,@Param("user_id") int user_id);

    int selectArticlesPageNum();

    int selectArticlesPageNumUser(@Param("user_id") int user_id);
}
