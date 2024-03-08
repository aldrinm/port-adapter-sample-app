package aldrinm.adapter.in.rest;

import aldrinm.application.port.in.SearchTracksUseCase;
import aldrinm.model.Track;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("/tracks")
@Produces(MediaType.APPLICATION_JSON)
public class SearchTrackController {

    private final SearchTracksUseCase searchTracksUseCase;
    private final TrackWebModelMapper trackMapper = Mappers.getMapper(TrackWebModelMapper.class);

    public SearchTrackController(SearchTracksUseCase searchTracksUseCase) {
        this.searchTracksUseCase = searchTracksUseCase;
    }

    @GET
    public List<TrackWebModel> findTracks(@QueryParam("searchstring") String searchString) {
        List<Track> tracks = searchTracksUseCase.searchTracks(searchString);
        return tracks.stream().map(trackMapper::fromDomain).toList();
    }

}
