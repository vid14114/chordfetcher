package model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Song {
    public abstract String artist();
    public abstract String title();
}
