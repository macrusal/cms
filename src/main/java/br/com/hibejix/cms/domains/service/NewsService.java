package br.com.hibejix.cms.domains.service;

import br.com.hibejix.cms.domains.models.News;
import br.com.hibejix.cms.domains.repository.NewsRepository;
import br.com.hibejix.cms.domains.vo.NewsRequest;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News update(String id, NewsRequest newsRequest) {
        final News news = this.newsRepository.findOne(id);
        news.setContent(newsRequest.getContent());
        news.setTitle(newsRequest.getTitle());
        return this.newsRepository.save(news);
    }
}
