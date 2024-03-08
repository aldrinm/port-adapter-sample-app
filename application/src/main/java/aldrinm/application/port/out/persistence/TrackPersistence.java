package aldrinm.application.port.out.persistence;

import aldrinm.model.Track;

import java.util.List;

public interface TrackPersistence {
    List<Track> findByTrackNameOrArtist(String trackNameOrArtist);
}
