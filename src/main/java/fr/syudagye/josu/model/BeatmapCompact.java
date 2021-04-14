package fr.syudagye.josu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BeatmapCompact {

    @JsonProperty("difficulty_rating")
    private float difficultyRating;
    private int id;
    private GameMode mode;
    private RankStatus status;
    @JsonProperty("total_length")
    private int totalLength;
    private String version;

    // Optional properties
    private BeatmapsetCompact beatmapset;
    private String checksum;
    private Failtimes failtimes;
    @JsonProperty("max_combo")
    private int maxCombo;

    public float getDifficultyRating() {
        return difficultyRating;
    }

    public int getId() {
        return id;
    }

    public GameMode getMode() {
        return mode;
    }

    public RankStatus getStatus() {
        return status;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public String getVersion() {
        return version;
    }

    public static class Failtimes {

        private int[] exit;
        private int[] fail;

        public int[] getExit() {
            return exit;
        }

        public int[] getFail() {
            return fail;
        }
    }
}
