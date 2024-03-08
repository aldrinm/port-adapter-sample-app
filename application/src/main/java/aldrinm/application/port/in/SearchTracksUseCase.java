package aldrinm.application.port.in;

import aldrinm.model.Track;

import java.util.List;

public interface SearchTracksUseCase {

    List<Track> searchTracks(String trackNameOrArtist);
}
