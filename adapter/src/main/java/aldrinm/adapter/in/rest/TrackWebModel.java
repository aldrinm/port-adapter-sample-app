package aldrinm.adapter.in.rest;

import java.util.Collection;

public record TrackWebModel(String trackName, Collection<String> genres) {

    @Override
    public String toString() {
        return "TrackWebModel[" +
                "trackName=" + trackName + ", " +
                "genres=" + genres + ']';
    }


}
