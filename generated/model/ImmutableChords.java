package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Chords}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableChords.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Chords"})
public final class ImmutableChords extends Chords {
  private final Integer rating;
  private final Integer votes;
  private final String link;
  private final String title;

  private ImmutableChords(Integer rating, Integer votes, String link, String title) {
    this.rating = rating;
    this.votes = votes;
    this.link = link;
    this.title = title;
  }

  /**
   * @return The value of the {@code rating} attribute
   */
  @Override
  public Integer rating() {
    return rating;
  }

  /**
   * @return The value of the {@code votes} attribute
   */
  @Override
  public Integer votes() {
    return votes;
  }

  /**
   * @return The value of the {@code link} attribute
   */
  @Override
  public String link() {
    return link;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Chords#rating() rating} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for rating
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChords withRating(Integer value) {
    if (this.rating.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "rating");
    return new ImmutableChords(newValue, this.votes, this.link, this.title);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Chords#votes() votes} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for votes
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChords withVotes(Integer value) {
    if (this.votes.equals(value)) return this;
    Integer newValue = Objects.requireNonNull(value, "votes");
    return new ImmutableChords(this.rating, newValue, this.link, this.title);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Chords#link() link} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for link
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChords withLink(String value) {
    if (this.link.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "link");
    return new ImmutableChords(this.rating, this.votes, newValue, this.title);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Chords#title() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChords withTitle(String value) {
    if (this.title.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "title");
    return new ImmutableChords(this.rating, this.votes, this.link, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableChords} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableChords
        && equalTo((ImmutableChords) another);
  }

  private boolean equalTo(ImmutableChords another) {
    return rating.equals(another.rating)
        && votes.equals(another.votes)
        && link.equals(another.link)
        && title.equals(another.title);
  }

  /**
   * Computes a hash code from attributes: {@code rating}, {@code votes}, {@code link}, {@code title}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + rating.hashCode();
    h += (h << 5) + votes.hashCode();
    h += (h << 5) + link.hashCode();
    h += (h << 5) + title.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Chords} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Chords{"
        + "rating=" + rating
        + ", votes=" + votes
        + ", link=" + link
        + ", title=" + title
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Chords} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Chords instance
   */
  public static ImmutableChords copyOf(Chords instance) {
    if (instance instanceof ImmutableChords) {
      return (ImmutableChords) instance;
    }
    return ImmutableChords.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableChords ImmutableChords}.
   * @return A new ImmutableChords builder
   */
  public static ImmutableChords.Builder builder() {
    return new ImmutableChords.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableChords ImmutableChords}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_RATING = 0x1L;
    private static final long INIT_BIT_VOTES = 0x2L;
    private static final long INIT_BIT_LINK = 0x4L;
    private static final long INIT_BIT_TITLE = 0x8L;
    private long initBits = 0xfL;

    private Integer rating;
    private Integer votes;
    private String link;
    private String title;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Chords} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Chords instance) {
      Objects.requireNonNull(instance, "instance");
      rating(instance.rating());
      votes(instance.votes());
      link(instance.link());
      title(instance.title());
      return this;
    }

    /**
     * Initializes the value for the {@link Chords#rating() rating} attribute.
     * @param rating The value for rating 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder rating(Integer rating) {
      this.rating = Objects.requireNonNull(rating, "rating");
      initBits &= ~INIT_BIT_RATING;
      return this;
    }

    /**
     * Initializes the value for the {@link Chords#votes() votes} attribute.
     * @param votes The value for votes 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder votes(Integer votes) {
      this.votes = Objects.requireNonNull(votes, "votes");
      initBits &= ~INIT_BIT_VOTES;
      return this;
    }

    /**
     * Initializes the value for the {@link Chords#link() link} attribute.
     * @param link The value for link 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder link(String link) {
      this.link = Objects.requireNonNull(link, "link");
      initBits &= ~INIT_BIT_LINK;
      return this;
    }

    /**
     * Initializes the value for the {@link Chords#title() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableChords ImmutableChords}.
     * @return An immutable instance of Chords
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableChords build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableChords(rating, votes, link, title);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_RATING) != 0) attributes.add("rating");
      if ((initBits & INIT_BIT_VOTES) != 0) attributes.add("votes");
      if ((initBits & INIT_BIT_LINK) != 0) attributes.add("link");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      return "Cannot build Chords, some of required attributes are not set " + attributes;
    }
  }
}
