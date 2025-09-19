package medium;

import java.util.HashMap;
import java.util.Map;

public class DesignSpreadsheet3484 {
    Map<String, Integer> cells = new HashMap<>();

    public DesignSpreadsheet3484(int rows) {
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.remove(cell);
    }

    public int getValue(String formula) {
        int idx = formula.indexOf("+");
        String left = formula.substring(1, idx);
        String right = formula.substring(idx + 1);

        int valLeft =
                Character.isLetter(left.charAt(0))
                        ? cells.getOrDefault(left, 0)
                        : Integer.parseInt(left);
        int valRight =
                Character.isLetter(right.charAt(0))
                        ? cells.getOrDefault(right, 0)
                        : Integer.parseInt(right);

        return valLeft + valRight;
    }

    public static void main(String[] args) {
        DesignSpreadsheet3484 spreadsheet = new DesignSpreadsheet3484(10);
        spreadsheet.setCell("A2", 10);
        spreadsheet.setCell("B2", 10);
        System.out.println(spreadsheet.getValue("=A2+B2"));
    }
}
