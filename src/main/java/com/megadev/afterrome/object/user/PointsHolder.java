package com.megadev.afterrome.object.user;

public interface PointsHolder {
    double getPoints();

    void addPoints(double amount);

    boolean subtractPoints();
}
