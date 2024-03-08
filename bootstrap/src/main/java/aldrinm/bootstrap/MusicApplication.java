package aldrinm.bootstrap;

import aldrinm.adapter.in.rest.SearchTrackController;
import aldrinm.adapter.out.persistence.inmemory.InMemoryRepository;
import aldrinm.application.port.in.SearchTracksUseCase;
import aldrinm.application.port.out.persistence.TrackPersistence;
import aldrinm.application.service.SearchTracksService;
import jakarta.ws.rs.core.Application;

import java.util.Set;

public class MusicApplication extends Application {


    @Override
    public Set<Object> getSingletons() {
        TrackPersistence trackPersistence = new InMemoryRepository();
        SearchTracksUseCase searchTracksUseCase = new SearchTracksService(trackPersistence);
        return Set.of(
                new SearchTrackController(searchTracksUseCase)
        );
    }
}
