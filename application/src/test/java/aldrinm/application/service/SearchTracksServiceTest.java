package aldrinm.application.service;

import aldrinm.application.port.out.persistence.TrackPersistence;
import aldrinm.model.Track;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchTracksServiceTest {

    private final TrackPersistence trackPersistence = mock(TrackPersistence.class);
    private final SearchTracksService searchTracksService = new SearchTracksService(trackPersistence);

    @Test
    void findTracksByArtist() {
        var texaxHoldEm = new Track("Texas Hold 'Em", null, OffsetDateTime.now(), List.of("country"), 99);

        when(trackPersistence.findByTrackNameOrArtist(eq("beyonce"))).thenReturn(List.of(texaxHoldEm));
        List<Track> beyonceTracks = searchTracksService.searchTracks("beyonce");
        assertThat(beyonceTracks).isNotEmpty();
        assertThat(beyonceTracks.getFirst()).isEqualTo(texaxHoldEm);
    }

    @Test
    void findTracksByName() {
        var texaxHoldEm = new Track("Texas Hold 'Em", null, OffsetDateTime.now(), List.of("country"), 99);

        when(trackPersistence.findByTrackNameOrArtist(eq("texas"))).thenReturn(List.of(texaxHoldEm));
        List<Track> beyonceTracks = searchTracksService.searchTracks("texas");
        assertThat(beyonceTracks).isNotEmpty();
        assertThat(beyonceTracks.getFirst()).isEqualTo(texaxHoldEm);
    }
}