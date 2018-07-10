package garg.sarthik.news;

public class Articles {

    private String author;
    private String title;
    private String description;
    private String moreURL;
    private String imageURL;
    private String publishedAt;

    public Articles(String author, String title, String moreURL, String imageURL, String publishedAt) {
        this.author = author;
        this.title = title;
        this.moreURL = moreURL;
        this.imageURL = imageURL;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getMoreURL() {
        return moreURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
