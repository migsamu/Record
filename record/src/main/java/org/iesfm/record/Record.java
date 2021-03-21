package org.iesfm.record;

import java.util.HashSet;
import java.util.Objects;

public class Record {

    private String title;
    private String author;
    private HashSet<String> genres;

    public Record(String title, String author, HashSet<String> genres) {
        this.title = title;
        this.author = author;
        this.genres = genres;
    }


    public boolean hasGenre(String genre) {
        return genres.contains(genre);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashSet<String> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(title, record.title) && Objects.equals(author, record.author) && Objects.equals(genres, record.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genres);
    }

    @Override
    public String toString() {
        return "Record{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + genres +
                '}';
    }
}
