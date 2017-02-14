package service;

import model.Song;
import service.chordsource.Chordsource;
import service.chordsource.UltimateGuitar;

import javax.inject.Singleton;

@Singleton
public class ChordFetcher {

    private Chordsource source;

    public ChordFetcher() {
        source = new UltimateGuitar();
    }

    private void setSource(Chordsource source) {
        this.source = source;
    }

    public String fetchChords(Song s) {
        return source.getChords(s);
    }
}
