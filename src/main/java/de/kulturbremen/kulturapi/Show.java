package de.kulturbremen.kulturapi;

import java.time.ZonedDateTime;

public class Show {
    private final String title;
    private final ZonedDateTime dateTime;
    private final String description;
    private final String url;
    private final String location;
    private final String category;
    private final Boolean isDubbed;


    public Show(String title, ZonedDateTime dateTime, String description, String url,
                String location, String category, Boolean isDubbed) {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.url = url;
        this.location = location;
        this.category = category;
        this.isDubbed = isDubbed;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getDateTime() {
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
