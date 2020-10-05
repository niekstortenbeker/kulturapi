package de.kulturbremen.kulturapi;

import java.time.Instant;
import java.util.List;

public class Shows {
    private final Instant updateDate;
    private final Instant startDate;
    private final Instant stopDate;
    private final List<Show> showList;

    public Shows(List<Show> showList, Instant updateDate, Instant startDate,
                 Instant stopDate) {
        this.updateDate = updateDate;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.showList = showList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Instant getStopDate() {
        return stopDate;
    }

    public Instant getStartDate() {
        return startDate;
    }
}
