package aldrinm.application.service;

import aldrinm.application.port.in.SearchTracksUseCase;
import aldrinm.application.port.out.persistence.TrackPersistence;
import aldrinm.model.Track;

import java.util.List;

public class SearchTracksService implements SearchTracksUseCase {

    private final TrackPersistence trackPersistence;

    public SearchTracksService(TrackPersistence trackPersistence) {
        this.trackPersistence = trackPersistence;
    }

    @Override
    public List<Track> searchTracks(String trackNameOrArtist) {
        return trackPersistence.findByTrackNameOrArtist(trackNameOrArtist);
    }

}
