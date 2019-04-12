package spring_test.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import spring_test.config.AppConfig;
import spring_test.domain.Article;
import spring_test.service.ArticleService;

@Component
public class AppMain {
	@Autowired
	ArticleService service;		//의존 객체
	
	public AppMain() {
	}
	
	public AppMain(ArticleService service) {
		this.service = service;		//요구사항 변경시 코드 수정 발생
	}
	
	public void setArticleService(ArticleService service) {
		this.service = service;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AppMain app = ctx.getBean(AppMain.class);
		app.run();
		
		ctx.close();
	}
	
	public void run() {
		Article article = new Article("텍스트", "테스트 내용");
		service.insert(article);
		
		Article article2 = service.selectOne(100);
		System.out.println(article2);
	}
	
	/*
	public static void main(String[] args) {
		AppMain app = new AppMain();
		app.run();
	}
	*/
	
}
