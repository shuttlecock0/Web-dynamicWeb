package spring_test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {
		"spring_test"
		//"spring_test.app", "spring_test.dao", "spring_test.service"
})
public class AppConfig {
	
	/*v.1
	@Bean
	public ArticleDao articleDao() {
		return new ArticleDaoImpl();
	}
	
	@Bean
	public ArticleService articleService() {
		return new ArticleServiceImpl(articleDao());
	}

	@Bean
	public ArticleService articleService2() {
		ArticleServiceImpl service = new ArticleServiceImpl();
		service.setArticleDao(articleDao());
		return service;
	}
	
	@Bean(name="app")
	public AppMain getApp() {
		return new AppMain(articleService());
	}
	*/
}
