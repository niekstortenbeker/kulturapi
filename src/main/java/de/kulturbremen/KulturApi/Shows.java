package de.kulturbremen.KulturApi;

import java.time.ZonedDateTime;
import java.util.List;

public class Shows {
    private List<Show> showList;
    private ZonedDateTime updateDate;

    public Shows(List<Show> showList, ZonedDateTime updateDate) {
        this.showList = showList;
        this.updateDate = updateDate;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
