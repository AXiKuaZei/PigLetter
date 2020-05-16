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
    public List<Article> selectArticlesPage(int id, int size) {
        return articleMapper.selectArticlesPage(id,size);
    }

    @Override
    public List<Article> selectArticlesPageUser(int id, int size, int user_id) {
        return articleMapper.selectArticlesPageUser(id,size,user_id);
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

    @Override
    public int selectArticlesPageNum(int size) {
        int page=(int)Math.ceil(articleMapper.selectArticlesPageNum()/(float)size);
        return page>0?page:1;
    }

    @Override
    public int selectArticlesPageNumUser(int size, int user_id) {
        int page=(int)Math.ceil(articleMapper.selectArticlesPageNumUser(user_id)/(float)size);
        return page>0?page:1;
    }
}
