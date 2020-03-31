package cn.pigletter.service.impl;

import cn.pigletter.dao.ArticleMapper;
import cn.pigletter.model.Article;
import cn.pigletter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;


    @Override
    public List<Article> selectArticles() {
        return articleMapper.selectArticles();
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void deleteArticleByID(int id) {
        articleMapper.deleteArticleByID(id);
    }

    @Override
    public Article selectArticleByID(int id) { return articleMapper.selectArticleByID(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
}
