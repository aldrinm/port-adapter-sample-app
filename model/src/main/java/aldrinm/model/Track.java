package aldrinm.model;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public final class Track {
    private final String trackName;
    private final Boolean isExplicit;
    private final OffsetDateTime albumReleaseDate;
    private final Collection<String> genres;
    private Integer popularity;


    public Track(String trackName, Boolean isExplicit, OffsetDateTime albumReleaseDate, Collection<String> genres, Integer popularity) {
        this.trackName = trackName;
        this.isExplicit = isExplicit;
        this.albumReleaseDate = albumReleaseDate;
        this.genres = genres;
        this.popularity = popularity;
    }

    void updateGenres(Collection<String> genres) {
        this.genres.clear();
        this.genres.addAll(genres);
    }

    void updatePopularity(Integer popularity) {
        this.popularity = popularity;
    }


    public String getTrackName() {
        return trackName;
    }

    public Boolean getExplicit() {
        return isExplicit;
    }

    public OffsetDateTime getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public Collection<String> getGenres() {
        return genres;
    }

    public Integer getPopularity() {
        return popularity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Track) obj;
        return Objects.equals(this.trackName, that.trackName) &&
                Objects.equals(this.isExplicit, that.isExplicit) &&
                Objects.equals(this.albumReleaseDate, that.albumReleaseDate) &&
                Objects.equals(this.genres, that.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackName, isExplicit, albumReleaseDate, genres);
    }

    @Override
    public String toString() {
        return "Track[" +
                "trackName=" + trackName + ", " +
                "is_explicit=" + isExplicit + ", " +
                "albumReleaseDate=" + albumReleaseDate + ", " +
                "genres=" + genres + ']';
    }

}
