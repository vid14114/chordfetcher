package model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Chords implements Comparable {
    public abstract Integer rating();
    public abstract Integer votes();
    public abstract String link();
    public abstract String title();

    @Override
    public int compareTo(Object o) {
        Chords c = (Chords) o;
        if(c.title().contains("Acoustic") && !title().contains("Acoustic"))
            return -1;
        if(c.title().contains("Ukulele") && !title().contains("Ukulele"))
            return -1;
        if(c.rating() - rating() == 0)
            return c.votes()-votes();
        return c.rating()-rating();
    }
}
