/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.HashMap;

/**
 *
 * @author Mathias
 */
public class BrickCalculator {

    public HashMap<String, Integer> calculate(String width, String length, String height) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("height", Integer.parseInt(height));
        map.put("width", Integer.parseInt(width));
        map.put("length", Integer.parseInt(length));
        int count2x4 = 0;
        int count2x2 = 0;
        int count2x1 = 0;

        //blockarray holds 3 integers, one for each type of block
        int[] blockArray = {0, 0, 0};

        /*
        Loops from 0 until number of layers, alternating by adding either 
        a layer where the corners are taken up by the lengthside, or a 
        layer where the corners are taken up by the width side. Thus, it 
        calculates a list of pieces that when put together right will have
        overlap between all the layers. 
         */
        for (int i = 0; i < map.get("height"); i++) {
            if (i % 2 == 0) {
                int[] lengthArray = calcLength(map);
                blockArray[0] += lengthArray[0];
                blockArray[1] += lengthArray[1];
                blockArray[2] += lengthArray[2];
            } else {
                int[] array = calcWidth(map);
                blockArray[0] += array[0];
                blockArray[1] += array[1];
                blockArray[2] += array[2];
            }
        }


        map.put("total2x4", blockArray[0] * 2);
        map.put("total2x2", blockArray[1] * 2);
        map.put("total2x1", blockArray[2] * 2);
        return map;
    }

    public int[] calcLength(HashMap<String, Integer> map) {
        int[] arr = {0, 0, 0};
        //arr[0] = amount of 2x4s in the layer
        //arr[1] = amount of 2x2s in the layer
        //arr[2] = amount of 2x1s in the layer
        int lengthSide = map.get("length");
        //corners are taken up by lengthsides so widthside will be its actual length -4
        int widthSide = map.get("width") - 4;

        //count bricks for length side
        arr[0] += (int) lengthSide / 4;
        int rest = lengthSide % 4;
        if (rest == 1) {
            arr[2]++;
        }
        if (rest == 2) {
            arr[1]++;
        }
        if (rest == 3) {
            arr[1]++;
            arr[2]++;
        }

        //count bricks for width side
        arr[0] += (int) widthSide / 4;
        int restwidth = widthSide % 4;
        if (restwidth == 1) {
            arr[2]++;
        }
        if (restwidth == 2) {
            arr[1]++;
        }
        if (restwidth == 3) {
            arr[1]++;
            arr[2]++;
        }
        return arr;
    }

    public int[] calcWidth(HashMap<String, Integer> map) {
        int[] arr = {0, 0, 0};
        //arr[0] = amount of 2x4s in the layer
        //arr[1] = amount of 2x2s in the layer
        //arr[2] = amount of 2x1s in the layer

        //corners are taken up by widthsides so lengthside will be its actual length -4
        int lengthSide = map.get("length") - 4;
        int widthSide = map.get("width");

        //count bricks for length side
        arr[0] += (int) lengthSide / 4;
        int rest = lengthSide % 4;
        if (rest == 1) {
            arr[2]++;
        }
        if (rest == 2) {
            arr[1]++;
        }
        if (rest == 3) {
            arr[1]++;
            arr[2]++;
        }

        //count bricks for width side
        arr[0] += (int) widthSide / 4;
        int restwidth = widthSide % 4;
        if (restwidth == 1) {
            arr[2]++;
        }
        if (restwidth == 2) {
            arr[1]++;
        }
        if (restwidth == 3) {
            arr[1]++;
            arr[2]++;
        }
        return arr;
    }

}
