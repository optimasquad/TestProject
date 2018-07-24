package com.compliance.repo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.compliance.repo.entity.Article;
import com.compliance.write.repo.repository.AbstractWriteRepo;

@Repository
public interface ArticleRepository extends AbstractWriteRepo<Article, Long> {
	List<Article> findByTitle(String title);

	List<Article> findDistinctByCategory(String category);


}
