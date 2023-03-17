package ind.awhic.nouvites.service.controller;

import ind.awhic.nouvites.model.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1")
public class ArticlesController {

    private final NewsService newsService;

    public ArticlesController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/version")
    public String getVersion() {
        return "NouVites version 0.1.0";
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles() throws IOException {
        List<Article> articles = newsService.getTopHeadlines();

        if (articles == null || articles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articles);
    }
}
