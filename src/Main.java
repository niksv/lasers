import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int iterations = 0;
    private static void solve(Field field, String cells) {
        Map<Character, Integer> cellMap = new HashMap<>();
        for (int i = 0; i < cells.length(); i++) {
            if (!cellMap.containsKey(cells.charAt(i))) {
                cellMap.put(cells.charAt(i), 0);
            }
            cellMap.put(cells.charAt(i), cellMap.get(cells.charAt(i)) + 1);
        }

        check(field, cellMap, 1, 1);
    }

    private static boolean check(Field field, Map<Character, Integer> cells, int x, int y) {
        boolean needCheck = true;
        for (Integer count : cells.values()) {
            if (count != 0) {
                needCheck = false;
                break;
            }
        }

        if (needCheck) {
            iterations++;
            boolean fin = field.check();
            if (fin) {
                System.out.println(field);
                System.out.println(iterations);
            }
            return false;
        }

        if (x == -1 || y == -1) {
            return false;
        }

        int nx = -1;
        int ny = -1;

        if (y + 2 < field.c) {
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
        Field field = new Field(5, 4);
        field.addLazer(9, 8, 'l');
        field.addHole(3, 6);
        field.addHole(5, 8);
        field.addHole(7, 2);
        field.addHole(7, 8);
//        field.field[11][1] = '.';
        System.out.println(field);
//        System.out.println(field.check());
        solve(field, "WWwww");
        System.out.println(iterations);
    }
}
