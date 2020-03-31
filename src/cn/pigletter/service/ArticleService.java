package cn.pigletter.service;

import cn.pigletter.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectArticles();

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);
}
