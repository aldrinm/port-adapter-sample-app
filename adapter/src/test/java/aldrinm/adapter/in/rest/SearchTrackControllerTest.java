package aldrinm.adapter.in.rest;

import aldrinm.application.port.in.SearchTracksUseCase;
import aldrinm.model.Track;
import io.restassured.response.Response;
import jakarta.ws.rs.core.Application;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

import static aldrinm.adapter.in.rest.TestCommon.TEST_PORT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchTrackControllerTest {

    private static final SearchTracksUseCase searchTracksUseCase = mock(SearchTracksUseCase.class);
    private static UndertowJaxrsServer server;

    @BeforeAll
    static void init() {
        server = new UndertowJaxrsServer().setPort(TEST_PORT).start().deploy(   new Application() {
            @Override
            public Set<Object> getSingletons() {
                return Set.of(new SearchTrackController(searchTracksUseCase));
            }
        });
    }

    @AfterAll
    static void stop() {
        server.stop();
    }

    @BeforeEach
    void resetMocks() {
        Mockito.reset(searchTracksUseCase);
    }

    @Test
    void ableToSearch() {
        when(searchTracksUseCase.searchTracks(eq("beyonce")))
                .thenReturn(List.of(new Track("Texas Hold 'Em", null, OffsetDateTime.now(), Set.of("country"), 90)));

        given().port(TEST_PORT).get("/tracks?searchstring=beyonce").then().body("trackName", hasItems("Texas Hold 'Em"));
    }
}