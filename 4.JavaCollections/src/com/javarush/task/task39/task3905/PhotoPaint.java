package com.javarush.task.task39.task3905;

public class PhotoPaint {

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {

        if (image.length > x && image[0].length > y && !image[y][x].equals(desiredColor)){
            Color old = image[y][x];
            image[y][x] = desiredColor;
            if (x+1 < image[y].length && image[y][x+1].equals(old))
                paintFill(image, x+1, y, desiredColor);
            if (x-1 >= 0 && image[y][x-1].equals(old))
                paintFill(image, x-1, y, desiredColor);
            if (y+1 < image.length && image[y+1][x].equals(old))
                paintFill(image, x, y+1, desiredColor);
            if (y-1 >= 0 && image[y-1][x].equals(old))
                paintFill(image, x, y-1, desiredColor);
            return true;
        }
        return false;
    }
}
