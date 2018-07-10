package rs21.newsupdates;

class Article {

    String author, title, url, imageUrl, date;

    public Article(String author, String title, String url, String imageUrl, String date) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }
}
