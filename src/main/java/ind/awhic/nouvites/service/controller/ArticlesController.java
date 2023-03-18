package ind.awhic.nouvites.service.controller;

import ind.awhic.nouvites.model.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/articles")
public class ArticlesController {

    private final NewsService newsService;

    public ArticlesController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top-stories")
    public ResponseEntity<List<Article>> getArticles() throws IOException {
        List<Article> articles = newsService.getTopHeadlines();

        if (articles == null || articles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articles);
    }


    @GetMapping("/test-data")
    public ResponseEntity<List<Article>> getTestArticles() {
        Article article1 = new Article();
        article1.setTitle("Tesla reports record sales in Q1 2023");
        article1.setDescription("Tesla announced on Wednesday that it sold a record 184,800 vehicles in the first quarter of 2023, marking a 45% increase from the same period last year.");
        article1.setUrl("https://www.reuters.com/business/autos-transportation/tesla-reports-record-sales-q1-2023-2023-04-05/");
        article1.setSource("Reuters");
        article1.setPublishedAt("2023-04-05T20:14:23Z");
        article1.setImageUrl("https://thumbs.dreamstime.com/z/newspaper-headline-breaking-news-51359996.jpg");

        Article article2 = new Article();
        article2.setTitle("Apple unveils new iPhone with foldable screen");
        article2.setDescription("Apple on Tuesday announced its latest iPhone model, which features a foldable screen and improved camera technology.");
        article2.setUrl("https://www.cnn.com/2023/04/04/tech/apple-iphone-foldable-screen/index.html");
        article2.setSource("CNN");
        article2.setPublishedAt("2023-04-04T22:17:13Z");
        article2.setImageUrl("https://thumbs.dreamstime.com/z/newspaper-headline-breaking-news-51359996.jpg");

        Article article3 = new Article();
        article3.setTitle("COVID-19 vaccine distribution expands to rural areas");
        article3.setDescription("As part of an effort to reach underserved communities, the U.S. government is expanding the distribution of COVID-19 vaccines to rural areas across the country.");
        article3.setUrl("https://thumbs.dreamstime.com/z/newspaper-headline-breaking-news-51359996.jpg");
        article3.setSource("NPR");
        article3.setPublishedAt("2023-04-03T17:29:56Z");
        article3.setImageUrl("https://media.npr.org/assets/img/2023/04/03/gettyimages-1309598719_wide-a03264799d831a16c23e1dcf27c067d8d0aa9544.jpg");

        Article article4 = new Article();
        article4.setTitle("Apple announces new MacBook Pro models with M2 chips");
        article4.setDescription("Apple has announced the release of new MacBook Pro models featuring their next-generation M2 chips. The new laptops are expected to offer significant performance improvements over their predecessors.");
        article4.setUrl("https://www.apple.com/newsroom/2023/03/apple-announces-new-macbook-pro-models-with-m2-chips/");
        article4.setSource("Apple Newsroom");
        article4.setPublishedAt(String.valueOf(Instant.parse("2023-03-15T19:00:00Z")));
        article4.setImageUrl("https://www.apple.com/newsroom/images/product/macbook-pro/standard/Apple_MacBook-Pro_16in_11082021_inline.jpg.large.jpg");

        Article article5 = new Article();
        article5.setTitle("Elon Musk's SpaceX announces new mission to Mars");
        article5.setDescription("SpaceX has announced plans for a new mission to Mars, with the goal of establishing a permanent human presence on the red planet. The mission is scheduled for launch in 2025.");
        article5.setUrl("https://www.spacex.com/news/2023/03/16/spacex-announces-new-mission-mars");
        article5.setSource("SpaceX");
        article5.setPublishedAt("2023-04-03T17:29:56Z");
        article5.setImageUrl("https://www.spacex.com/static/images/share.jpg");

        Article article6 = new Article();
        article6.setTitle("New study shows benefits of exercise for mental health");
        article6.setDescription("A new study published in the Journal of Psychology has shown that regular exercise can have significant positive effects on mental health, including reducing symptoms of depression and anxiety.");
        article6.setUrl("https://www.psychologytoday.com/us/blog/the-athletes-way/202303/new-study-shows-benefits-exercise-mental-health");
        article6.setSource("Psychology Today");
        article6.setPublishedAt("2023-04-03T17:29:56Z");
        article6.setImageUrl("https://www.psychologytoday.com/sites/default/files/styles/image-article_inline_full/public/field_blog_entry_teaser_image/Physical_Activity_0.jpg?itok=nRwT8CO7");


        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);

        return ResponseEntity.ok(articles);
    }
}
