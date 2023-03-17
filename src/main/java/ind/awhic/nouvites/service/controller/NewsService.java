package ind.awhic.nouvites.service.controller;

import ind.awhic.nouvites.model.Article;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class NewsService {

    private static final String API_KEY = "20f2699c7a92485da710b0c6dd872c14";

    public ArrayList<Article> getTopHeadlines() throws IOException {
        ArrayList<Article> articles = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        String url = "https://newsapi.org/v2/top-headlines?country=" + "us" + "&apiKey=" + API_KEY;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            JSONObject json = new JSONObject(response.body().string());
            JSONArray jsonArticles = json.getJSONArray("articles");

            for (int i = 0; i < jsonArticles.length(); i++) {
                JSONObject jsonArticle = jsonArticles.getJSONObject(i);
                Article article = new Article();
                article.setTitle(jsonArticle.getString("title"));
                article.setDescription(jsonArticle.getString("description"));
                article.setUrl(jsonArticle.getString("url"));
                article.setSource(jsonArticle.getJSONObject("source").getString("name"));
                article.setPublishedAt(jsonArticle.getString("publishedAt"));
                article.setImageUrl(jsonArticle.optString("urlToImage"));
                articles.add(article);
            }
        }
        return articles;
    }

}
