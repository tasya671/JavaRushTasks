package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {

    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("./4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level){
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction))
            return;
        if (checkBoxCollisionAndMoveIfAvailable(direction))
            return;
        switch (direction) {
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
                break;

        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        Set<Wall> wallSet = gameObjects.getWalls();
        for (Wall wall: wallSet) {
            if(gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        Player player = gameObjects.getPlayer();
        GameObject barrier = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction))
                barrier = gameObject;
        }
        if (barrier == null) return false;
        if (barrier instanceof Box) {
            Box box = (Box) barrier;
            if (checkWallCollision(box, direction)) return true;
            for (Box b : gameObjects.getBoxes()) {
                if (box.isCollision(b, direction)) return true;
            }
            switch (direction) {
                case LEFT: box.move(-FIELD_CELL_SIZE, 0); break;
                case RIGHT: box.move(FIELD_CELL_SIZE, 0); break;
                case UP : box.move(0, -FIELD_CELL_SIZE); break;
                case DOWN: box.move(0, FIELD_CELL_SIZE);
            }
        } else if(barrier instanceof Wall) return true;
        return false;
    }

    public void checkCompletion(){
        Set<Home> homes = gameObjects.getHomes();
        Set<Box> boxes = gameObjects.getBoxes();
        int count = 0;

        for (Home home: homes) {
            for (Box box: boxes) {
                if(home.getX()==box.getX() && home.getY()==box.getY()){
                    count++;
                    break;
                }
            }
        }
        if(count == homes.size())
            eventListener.levelCompleted(currentLevel);
    }

}
