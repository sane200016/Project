package com.llaminator.ghostline;

/**
 * Created by Артём on 07.06.2017.
 */

public class Route {
    RouteStep Level [];

    public Route(RouteStep[] level) {
        Level = level;
    }

    public RouteStep[] getLevel() {
        return Level;
    }

    public void setLevel(RouteStep[] level) {
        Level = level;
    }


}
