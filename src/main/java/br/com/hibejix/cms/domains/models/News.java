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


    /*
     * Check if the news was reviewed by all mandatory reviewers
     */
    public Review review(final String userId, final String status) {
        final Review review = new Review(userId, status);
        this.reviewrs.add(review);
        return review;
    }

    /*
     * Check if the news was fully revised by all mandatory reviewers
     */
    public Boolean revised() {
        return this.mandatoryReviwers.stream().allMatch(
                reviewr -> this.reviewrs.stream().anyMatch(
                        review -> reviewr.getId().equals(review.getUserId()) && "approved".equals(review.getStatus())
                )
        );
    }
}
