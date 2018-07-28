package br.com.hibejix.cms.domains.models;

import lombok.Data;

import java.util.Set;

@Data
public class News {

    private String id;

    private String title;

    private String content;

    private User author;

    private Set<User> mandatoryReviwers;

    private Set<Review> reviewrs;

    private Set<Category> categories;

    private Set<Tag> tags;
}
