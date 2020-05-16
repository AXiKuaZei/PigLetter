package cn.pigletter.service;

import cn.pigletter.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectArticles();

    List<Article> selectArticlesPage(int id, int size);

    List<Article> selectArticlesPageUser(int id, int size, int user_id);

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);

    int selectArticlesPageNum(int size);

    int selectArticlesPageNumUser(int size,int user_id);
}
