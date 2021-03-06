package athena.party.resource.playlist;

/**
 * Represents playlist-data for a party.
 */
public final class PartyPlaylistData {

    /**
     * Playlist related information and region.
     * see {@link athena.events.Events}
     */
    private String playlistName, tournamentId, eventWindowId, regionId;

    public PartyPlaylistData(String playlistName, String tournamentId, String eventWindowId, String regionId) {
        this.playlistName = playlistName;
        this.tournamentId = tournamentId;
        this.eventWindowId = eventWindowId;
        this.regionId = regionId;
    }

    /**
     * @return the playlist name.
     */
    public String playlistName() {
        return playlistName;
    }

    /**
     * @return the tournament ID or {@code ""}
     */
    public String tournamentId() {
        return tournamentId;
    }

    /**
     * @return the event window ID or {@code ""}
     */
    public String eventWindowId() {
        return eventWindowId;
    }

    /**
     * @return the region, ex: "NAE"
     */
    public String regionId() {
        return regionId;
    }
}
