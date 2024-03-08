package aldrinm.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TrackTest {

    @Test
    void canUpdateGenres() {
        Track track1 = new Track("Texas Hold 'Em", null, OffsetDateTime.now(), List.of("country"), 99);

        assertThat(track1.getPopularity()).isEqualTo(99);

        track1.updatePopularity(80);
        assertThat(track1.getPopularity()).isEqualTo(80);

    }

}