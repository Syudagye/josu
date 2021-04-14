package fr.syudagye.josu;

import fr.syudagye.josu.model.Beatmap;

public interface OsuClient {

    String OSU_ENDPOINT = "https://osu.ppy.sh/api/v2/";

    Beatmap getBeatmap(String beatmapId);

}
