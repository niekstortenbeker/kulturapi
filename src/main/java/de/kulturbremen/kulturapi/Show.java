package de.kulturbremen.kulturapi;

import java.time.Instant;

public class Show {

    private final String title;
    private final Instant dateTime;
    private final String description;
    private final String url;
    private final String location;
    private final String category;
    private final Boolean isDubbed;


    public Show(String title, Instant dateTime, String description, String url,
                String location, String category, Boolean isDubbed) {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.url = url;
        this.location = location;
        this.category = category;
        this.isDubbed = isDubbed;
    }

    @Override
    public String toString() {
        return String.format(
                "Show[title='%s', date='%s', description='%s', url='%s', location='%s', category='%s', isDubbed='%s']",
                title, dateTime, description, url, location, category, isDubbed);
    }

    public String getTitle() {
        return title;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getIsDubbed() {
        return isDubbed;
    }
}
