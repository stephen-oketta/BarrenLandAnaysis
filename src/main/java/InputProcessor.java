package main.java;

import java.util.Arrays;

public class InputProcessor {
    public int[][] getInput(String input) {

        int len = input.length();
        if (input.isEmpty() || input.charAt(0) != '{' || input.charAt(len-1) != '}') {
            return null;
        }

        String[] barrenLands = input.substring(1, len - 1).replaceAll("\"", "").split(", ");

        if (barrenLands.length == 1 && barrenLands[0].trim().isEmpty()) {
            return new int[][]{};
        }

        int[][] result = new int[barrenLands.length][];

        try {
            int index = 0;
            for (String barrenLand : barrenLands) {
                int[] intBarrenLand = Arrays.stream(barrenLand.split(" ")).mapToInt(Integer::parseInt).toArray();
                result[index++] = intBarrenLand;
            }

        } catch (Exception e) {
            return null;
        }

        return  result;
    }
}
