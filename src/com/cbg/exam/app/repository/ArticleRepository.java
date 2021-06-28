package com.cbg.exam.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.cbg.exam.app.dto.Article;

public class ArticleRepository {

	public Article getArticleById(int id, List<Article> articles) {
		for(Article a : articles) {
			if(a.id == id) {
				Article article = a;
				return article;
			}
		}
		return null;
		
	}

	

}
