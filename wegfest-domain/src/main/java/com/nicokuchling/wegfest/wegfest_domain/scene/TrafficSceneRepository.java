package com.nicokuchling.wegfest.wegfest_domain.scene;

import java.util.List;

public interface TrafficSceneRepository {

    List<TrafficScene> getAll();

    TrafficScene get(TrafficSceneId trafficSceneId);
}
