package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Song}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSong.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Song"})
public final class ImmutableSong extends Song {
  private final String artist;
  private final String title;

  private ImmutableSong(String artist, String title) {
    this.artist = artist;
    this.title = title;
  }

  /**
   * @return The value of the {@code artist} attribute
   */
  @Override
  public String artist() {
    return artist;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Song#artist() artist} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for artist
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSong withArtist(String value) {
    if (this.artist.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "artist");
    return new ImmutableSong(newValue, this.title);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Song#title() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSong withTitle(String value) {
    if (this.title.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "title");
    return new ImmutableSong(this.artist, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSong} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSong
        && equalTo((ImmutableSong) another);
  }

  private boolean equalTo(ImmutableSong another) {
    return artist.equals(another.artist)
        && title.equals(another.title);
  }

  /**
   * Computes a hash code from attributes: {@code artist}, {@code title}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + artist.hashCode();
    h += (h << 5) + title.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Song} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Song{"
        + "artist=" + artist
        + ", title=" + title
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Song} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Song instance
   */
  public static ImmutableSong copyOf(Song instance) {
    if (instance instanceof ImmutableSong) {
      return (ImmutableSong) instance;
    }
    return ImmutableSong.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSong ImmutableSong}.
   * @return A new ImmutableSong builder
   */
  public static ImmutableSong.Builder builder() {
    return new ImmutableSong.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSong ImmutableSong}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_ARTIST = 0x1L;
    private static final long INIT_BIT_TITLE = 0x2L;
    private long initBits = 0x3L;

    private String artist;
    private String title;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Song} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Song instance) {
      Objects.requireNonNull(instance, "instance");
      artist(instance.artist());
      title(instance.title());
      return this;
    }

    /**
     * Initializes the value for the {@link Song#artist() artist} attribute.
     * @param artist The value for artist 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder artist(String artist) {
      this.artist = Objects.requireNonNull(artist, "artist");
      initBits &= ~INIT_BIT_ARTIST;
      return this;
    }

    /**
     * Initializes the value for the {@link Song#title() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSong ImmutableSong}.
     * @return An immutable instance of Song
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSong build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSong(artist, title);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ARTIST) != 0) attributes.add("artist");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      return "Cannot build Song, some of required attributes are not set " + attributes;
    }
  }
}
