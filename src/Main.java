import java.util.HashMap;
import java.util.Map;

public class Main {
    private static void solve(AdvancedField field, String cells) {
        Map<Character, Integer> cellMap = new HashMap<>();
        for (int i = 0; i < cells.length(); i++) {
            if (!cellMap.containsKey(cells.charAt(i))) {
                cellMap.put(cells.charAt(i), 0);
            }
            cellMap.put(cells.charAt(i), cellMap.get(cells.charAt(i)) + 1);
        }

        check(field, cellMap, 1, 1);
    }

    private static boolean check(AdvancedField field, Map<Character, Integer> cells, int x, int y) {
        boolean needCheck = true;
        for (Integer count : cells.values()) {
            if (count != 0) {
                needCheck = false;
                break;
            }
        }

        if (needCheck) {
            boolean fin = field.check();
            if (fin) {
                System.out.println(field);
            }
            return fin;
        }

        if (x == -1 || y == -1) {
            return false;
        }

        int nx = -1;
        int ny = -1;

        if (y + 2 <field.c) {
            nx = x;
            ny = y + 2;
        } else {
            if (x + 2 < field.l) {
                nx = x + 2;
                ny = 1;
            }
        }

        if (field.field[x][y] != ' ') {
            return check(field, cells, nx, ny);
        }

        for (Character c : cells.keySet()) {
            if (cells.get(c) > 0) {
                field.field[x][y] = c;
                cells.put(c, cells.get(c) - 1);

                boolean res = check(field, cells, nx, ny);
                if (res) {
                    return true;
                }

                cells.put(c, cells.get(c) + 1);
            }
        }
        field.field[x][y] = ' ';
        return check(field, cells, nx, ny);
    }


    public static void main(String[] args) {
        AdvancedField field = new AdvancedField(5, 5);
        field.addLazer(1, 2, 'r');
        field.addLazer(4, 9, 'd');
        field.addHole(3, 6);
        field.addHole(5, 6);
        field.addHole(7, 6);
        field.addHole(6, 9);
        field.addHole(9, 2);
        field.field[1][1] = '.';
        field.field[1][9] = '.';
        field.field[5][5] = '.';
        field.field[9][1] = '.';
        field.field[9][9] = '.';
        System.out.println(field);
//        System.out.println(field.check());
        solve(field, "WWWWW");
    }
}
