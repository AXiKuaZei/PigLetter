package cn.pigletter.dao;

import cn.pigletter.model.Article;



import java.util.List;


public interface ArticleMapper {
    //返回所有文章
    List<Article> selectArticles();

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);
}
