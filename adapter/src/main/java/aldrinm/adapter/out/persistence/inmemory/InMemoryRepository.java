package aldrinm.adapter.out.persistence.inmemory;

import aldrinm.application.port.out.persistence.TrackPersistence;
import aldrinm.model.Track;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

public class InMemoryRepository implements TrackPersistence {

    private List<Track> tracks = List.of(
            new Track("Texas Hold 'Em", null, OffsetDateTime.now(), Set.of("country"), null)
    );

    @Override
    public List<Track> findByTrackNameOrArtist(String trackNameOrArtist) {
        return tracks.stream().filter(track -> track.getTrackName().contains(trackNameOrArtist)).toList();
    }
}
