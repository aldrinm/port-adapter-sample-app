package aldrinm.adapter.out.persistence.inmemory;

import aldrinm.model.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryRepositoryTest {

    private InMemoryRepository inMemoryRepository;

    @BeforeEach
    void initRepo() {
        inMemoryRepository = new InMemoryRepository();
    }


    @Test
    void canFindByTrackName() {
        List<Track> texas = inMemoryRepository.findByTrackNameOrArtist("Texas");
        assertThat(texas.getFirst().getTrackName()).isEqualTo("Texas Hold 'Em");
    }

}