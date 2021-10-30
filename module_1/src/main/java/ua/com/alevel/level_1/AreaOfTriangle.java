package ua.com.alevel.level_1;

import java.awt.*;

public final class AreaOfTriangle {

    public static boolean calculateTriangle(Point A, Point B, Point C) {
        int area = A.x * (B.y - C.y) +
                B.x * (C.y - A.y) +
                C.x * (A.y - B.y);
        return area != 0;
    }

    public static double calcPerimeter(Point A, Point B, Point C) {
        return A.distance(B) + B.distance(C) + A.distance(C);
    }

    public static double calcSquare(Point A, Point B, Point C) {
        double halfPerimeter = calcPerimeter(A, B, C) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - A.distance(B)) *
                (halfPerimeter - B.distance(C)) * (halfPerimeter - A.distance(C)));
    }
}