package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();
    private  boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.score = 0;
        this.maxTile = 0;
        addTile();
        addTile();
    }


    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].isEmpty())
                    list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles.size() != 0) {
            int position = (int) (tiles.size() * Math.random());
            int newValue = Math.random() < 0.9 ? 2 : 4;
            tiles.get(position).value = newValue;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean compress = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    compress = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
        return compress;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean merge = false;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i].value == tiles[i - 1].value & !tiles[i].isEmpty() & !tiles[i - 1].isEmpty()) {
                merge = true;
                tiles[i - 1].value += tiles[i].value;
                maxTile = (maxTile < tiles[i - 1].value) ? tiles[i - 1].value : maxTile;
                score += tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
        return merge;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) addTile();
        isSaveNeeded = true;
    }


    private void rotateArray() {

        int arraySize = gameTiles.length - 1;
        int middle = gameTiles.length / 2;

        for (int i = 0; i < middle; i++) {
            for (int j = i; j < arraySize - i; j++) {
                Tile tile = gameTiles[arraySize - i][j];
                gameTiles[arraySize - i][j] = gameTiles[arraySize - j][arraySize - i];
                gameTiles[arraySize - j][arraySize - i] = gameTiles[i][arraySize - j];
                gameTiles[i][arraySize - j] = gameTiles[j][i];
                gameTiles[j][i] = tile;
            }
        }
    }

    public void right() {
        saveState(gameTiles);
        rotateArray();
        rotateArray();
        left();
        rotateArray();
        rotateArray();
    }

    public void up() {
        saveState(gameTiles);
        rotateArray();
        rotateArray();
        rotateArray();
        left();
        rotateArray();
    }

    public void down() {
        saveState(gameTiles);
        rotateArray();
        left();
        rotateArray();
        rotateArray();
        rotateArray();
    }


    public boolean canMove(){
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j <gameTiles[0].length ; j++) {
                if(gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }

        for (int i = 0; i < gameTiles[0].length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i].value)
                    return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles){
        Tile [][] saves = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < saves.length; i++) {
            for (int j = 0; j <saves[0].length; j++) {
                Tile tile = new Tile(tiles[i][j].value);
                saves[i][j] = tile;
            }
        }
        previousStates.push(saves);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty() && !previousScores.isEmpty()){
        gameTiles = previousStates.pop();
        score = previousScores.pop();
        isSaveNeeded = true;
        }
    }


    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged(){
        Tile [][] undoTiles = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j <gameTiles[0].length ; j++) {
                if (gameTiles[i][j].value != undoTiles[i][j].value)
                    return true;
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        if(hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        else
            moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();
        return moveEfficiency;
    }


    public void autoMove(){
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.offer((getMoveEfficiency(this::left)));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        queue.poll().getMove().move();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
}