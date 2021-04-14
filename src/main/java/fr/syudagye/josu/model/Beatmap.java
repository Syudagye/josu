package fr.syudagye.josu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Beatmap extends BeatmapCompact{

    private float accuracy;
    private float ar;
    @JsonProperty("beatmapset_id")
    private int beatmapsetId;
    private float bpm;
    private boolean convert;
    @JsonProperty("count_circles")
    private int countCircles;
    @JsonProperty("count_sliders")
    private int countSliders;
    @JsonProperty("count_spinners")
    private int countSpinners;
    private int cs;
    private String timestamp; // TODO: 12/04/2021 Deserialize timestamps into timestamps objects
    private float drain;
    @JsonProperty("hit_length")
    private int hitLength;
    @JsonProperty("is_scoreable")
    private boolean scoreable;
    @JsonProperty("last_updated")
    private String lastUpdated; // TODO: 12/04/2021 Timestamp
    @JsonProperty("mode_int")
    private int modeInt;
    private int passcount;
    private int playcount;
    private RankStatus ranked;
    private String url;

    public float getAccuracy() {
        return accuracy;
    }

    public float getAr() {
        return ar;
    }

    public int getBeatmapsetId() {
        return beatmapsetId;
    }

    public float getBpm() {
        return bpm;
    }

    public boolean isConvert() {
        return convert;
    }

    public int getCountCircles() {
        return countCircles;
    }

    public int getCountSliders() {
        return countSliders;
    }

    public int getCountSpinners() {
        return countSpinners;
    }

    public int getCs() {
        return cs;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public float getDrain() {
        return drain;
    }

    public int getHitLength() {
        return hitLength;
    }

    public boolean isScoreable() {
        return scoreable;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public int getModeInt() {
        return modeInt;
    }

    public int getPasscount() {
        return passcount;
    }

    public int getPlaycount() {
        return playcount;
    }

    public RankStatus getRanked() {
        return ranked;
    }

    public String getUrl() {
        return url;
    }
}
