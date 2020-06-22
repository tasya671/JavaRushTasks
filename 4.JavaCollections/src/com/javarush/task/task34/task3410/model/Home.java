package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {

    public Home(int x, int y) {
        super(x, y);
        this.setHeight(2);
        this.setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.BLUE);
        graphics.drawOval(this.getX()-this.getWidth()/2, this.getY()-this.getHeight()/2, this.getWidth(), this.getHeight());
        graphics.fillOval(this.getX()-this.getWidth()/2, this.getY()-this.getHeight()/2, this.getWidth(), this.getHeight());
    }
}
