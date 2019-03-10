package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Color;

import java.util.*;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private GameObject gameField[][] = new GameObject[SIDE][SIDE];
    private int countMinesOnField;


    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                int mine = getRandomNumber(10);
                boolean isMine = mine == 9 ? true : false;
                if (isMine) countMinesOnField += 1;
                gameField[x][y] = new GameObject(y, x, isMine); // WTF??? (y , x)???
                setCellColor(x, y, Color.BISQUE);
            }
        }
        countMineNeighbors();

    }

    private List<GameObject> getNeighbors(GameObject oneField) {
        int x = oneField.x;
        int y = oneField.y;
        int index = 0;
        List<GameObject> neighbors = new ArrayList();

        for (int iy = x - 1; iy <= x + 1; iy++) {
            for (int ix = y - 1; ix <= y + 1; ix++) {
                if ((ix != x | iy != y)
                        && (ix >= 0 & iy >= 0)
                        && (ix < SIDE & iy < SIDE)) {
                    neighbors.add(index, gameField[ix][iy]);
                    index += 1;
                }
            }
        }

        return neighbors;
    }

    private void countMineNeighbors() {
        List<GameObject> list2 = new ArrayList<>();
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (!gameField[y][x].isMine) {
                    list2 = getNeighbors(gameField[y][x]);
                    for (int i = 0; i < list2.size(); i++) {
                        if (list2.get(i).isMine)
                            gameField[y][x].countMineNeighbors++;
                    }
                }
            }
        }
    }
}