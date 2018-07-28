package br.com.hibejix.cms.domains.vo;

import br.com.hibejix.cms.domains.models.Category;
import br.com.hibejix.cms.domains.models.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

    private String title;

    private String content;

    private Set<Category> categories;

    private Set<Tag> tags;

}
