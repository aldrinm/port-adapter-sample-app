package aldrinm.adapter.in.rest;

import aldrinm.model.Track;
import org.mapstruct.Mapper;

@Mapper
public interface TrackWebModelMapper {

    TrackWebModel fromDomain(Track track);
}
