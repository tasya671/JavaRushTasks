package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int currentLevel = level>60? (level%60) : level;
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Player player = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String currentStr;
            while ((currentStr = reader.readLine()) != null) {
                if (currentStr.contains("Maze")) {
                    String[] content = currentStr.split(" ");
                    if (Integer.parseInt(content[1]) == currentLevel) {
                        int sizeX = 0;
                        int sizeY = 0;
                        while (!(currentStr = reader.readLine()).contains("*******")) {
                            if (currentStr.contains("Size Y")) {
                                content = currentStr.split(" ");
                                sizeY = Integer.parseInt(content[2]);
                            }
                            if (currentStr.equals("")) {
                                int y0 = Model.FIELD_CELL_SIZE / 2;
                                for (int i = 0; i < sizeY; i++) {
                                    currentStr = reader.readLine();
                                    int x0 = Model.FIELD_CELL_SIZE / 2;


                                    for (Character sim : currentStr.toCharArray()) {

                                        switch (sim) {

                                            case 'X':
                                                walls.add(new Wall(x0, y0));
                                                break;
                                            case '*':
                                                boxes.add(new Box(x0, y0));
                                                break;
                                            case '.':
                                                homes.add(new Home(x0, y0));
                                                break;
                                            case '&':
                                                homes.add(new Home(x0, y0));
                                                boxes.add(new Box(x0, y0));
                                                break;
                                            case '@':
                                                player = new Player(x0, y0);
                                        }
                                        x0 = x0 + Model.FIELD_CELL_SIZE;
                                    }
                                    y0 = y0 + Model.FIELD_CELL_SIZE;
                                }
                                GameObjects objects = new GameObjects(walls, boxes, homes, player);
                                return objects;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {  }
        return null;
    }
}
