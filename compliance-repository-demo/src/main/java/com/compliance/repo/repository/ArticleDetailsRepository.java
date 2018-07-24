package com.compliance.repo.repository;

import java.util.List;

import com.compliance.read.repo.repository.AbstractReadRepo;
import com.compliance.repo.entity.Article;

public interface ArticleDetailsRepository extends AbstractReadRepo<Article, Long>{

	List<Article> findByTitleAndCategory(String title, String category);
}
