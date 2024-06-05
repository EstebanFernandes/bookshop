package fr.univtours.polytech.bookshop.model.details;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author_name",
        "author_key",
        "cover_i",
        "first_publish_year",
        "title",
        "isbn",
        "language",
        "ratings_average",
        "ratings_count",
        "publisher",
        "publish_year",
        "place",
        "person"
})
@Generated("jsonschema2pojo")
public class Doc {
    @JsonProperty("author_key")
    private List<String> authorKey;

    @JsonProperty("author_name")
    private List<String> authorName;
    @JsonProperty("cover_i")
    private Integer coverI;
    @JsonProperty("first_publish_year")
    private Integer firstPublishYear;
    @JsonProperty("title")
    private String title;
    @JsonProperty("isbn")
    private List<String> isbn;
    @JsonProperty("language")
    private List<String> language;
    @JsonProperty("ratings_average")
    private Double ratingsAverage;
    @JsonProperty("ratings_count")
    private Integer ratingsCount;
    @JsonProperty("publisher")
    private List<String> publisher;
    @JsonProperty("publish_year")
    private List<Integer> publishYear;
    @JsonProperty("place")
    private List<String> place;
    @JsonProperty("person")
    private List<String> person;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("author_name")
    public List<String> getAuthor_name() {
        return authorName;
    }

    @JsonProperty("author_name")
    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("author_key")
    public List<String> getAuthor_key() {
        return authorKey;
    }

    @JsonProperty("author_key")
    public void setAuthorKey(List<String> authorKey) {
        this.authorKey = authorKey;
    }

    @JsonProperty("cover_i")
    public Integer getCover_i() {
        return coverI;
    }

    @JsonProperty("cover_i")
    public void setCoverI(Integer coverI) {
        this.coverI = coverI;
    }

    @JsonProperty("first_publish_year")
    public Integer getFirst_publish_year() {
        return firstPublishYear;
    }

    @JsonProperty("first_publish_year")
    public void setFirstPublishYear(Integer firstPublishYear) {
        this.firstPublishYear = firstPublishYear;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("isbn")
    public List<String> getIsbn() {
        return isbn;
    }

    @JsonProperty("isbn")
    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    @JsonProperty("language")
    public List<String> getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(List<String> language) {
        this.language = language;
    }

    @JsonProperty("ratings_average")
    public Double getRatings_average() {
        return ratingsAverage;
    }

    @JsonProperty("ratings_average")
    public void setRatingsAverage(Double ratingsAverage) {
        this.ratingsAverage = ratingsAverage;
    }

    @JsonProperty("ratings_count")
    public Integer getRatings_count() {
        return ratingsCount;
    }

    @JsonProperty("ratings_count")
    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    @JsonProperty("publisher")
    public List<String> getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("publish_year")
    public List<Integer> getPublish_year() {
        return publishYear;
    }

    @JsonProperty("publish_year")
    public void setPublishYear(List<Integer> publishYear) {
        this.publishYear = publishYear;
    }

    @JsonProperty("place")
    public List<String> getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(List<String> place) {
        this.place = place;
    }

    @JsonProperty("person")
    public List<String> getPerson() {
        return person;
    }

    @JsonProperty("person")
    public void setPerson(List<String> person) {
        this.person = person;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
