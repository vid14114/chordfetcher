package service.chordsource;


import model.Song;

public interface Chordsource {
    String getChords(Song s);
}
