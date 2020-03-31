package cn.pigletter.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Article {
    int article_id;

    @NotNull
    @Size(min=5)
    String article_title;

    String article_content;

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_title=" + article_title +
                ", article_content=" + article_content +
                '}';
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }
}
