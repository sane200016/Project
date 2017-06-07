package com.llaminator.ghostline;

import java.awt.Rectangle;

public class RouteStep {
    Rectangle Step;

    public RouteStep(Rectangle step, int width, int height) {
        Step = step;
    }

    public void setStep(Rectangle step) {
        Step = step;
    }

    public Rectangle getStep() {
        return Step;
    }
}
