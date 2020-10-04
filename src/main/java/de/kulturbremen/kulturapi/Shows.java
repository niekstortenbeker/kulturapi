package de.kulturbremen.kulturapi;

import java.time.ZonedDateTime;
import java.util.List;

public class Shows {
    private final ZonedDateTime updateDate;
    private final ZonedDateTime startDate;
    private final ZonedDateTime stopDate;
    private final List<Show> showList;

    public Shows(List<Show> showList, ZonedDateTime updateDate, ZonedDateTime startDate,
                 ZonedDateTime stopDate) {
        this.updateDate = updateDate;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.showList = showList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public ZonedDateTime getStopDate() {
        return stopDate;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }
}
