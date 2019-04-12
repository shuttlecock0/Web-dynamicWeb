package spring_test.dao;

import org.springframework.stereotype.Repository;

import spring_test.domain.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	public ArticleDaoImpl() {

	}

	@Override
	public void insert(Article article) {
		System.out.println("==== 글 저장 =========");
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getContent());
	}

	@Override
	public Article selectOne(int id) {
		System.out.println("글 id " + id + " 추출");
		return new Article("테스트" + id, "테스트 내용");
	}

	/*
	@PostConstruct
	public void open() {
		System.out.println("데이터베이스 연결");
	}

	@PreDestroy
	public void close() {
		System.out.println("데이터베이스 연결 해제");
	}
	*/
}
