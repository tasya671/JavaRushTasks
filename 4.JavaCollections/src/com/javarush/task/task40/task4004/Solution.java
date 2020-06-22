package com.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        boolean isInPolygon = false;
        for (int i = 0, j = polygon.size()-1; i < polygon.size() ; j=i++) {
            Point one = polygon.get(i);
            Point two = polygon.get(j);
            if ((((one.y <= point.y) && (point.y < two.y)) || ((two.y <= point.y) && (point.y < one.y))) &&
                    (((two.y-one.y != 0) && (point.x >= ((two.x-one.x) * (point.y- one.y)/(two.y - one.y) + one.x)))))
                isInPolygon = !isInPolygon;
        }
        return isInPolygon;
    }

}

