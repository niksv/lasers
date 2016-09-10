import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Directions {
    private static Map<Integer, Map<Character, Map<Character, List<Point>>>> d;
    private static void add(int type, char direction, char cellType, Point[] directions) {
        if (!d.containsKey(type)) {
            d.put(type, new HashMap<>());
        }
        if (!d.get(type).containsKey(direction)) {
            d.get(type).put(direction, new HashMap<>());
        }

        if (!d.get(type).get(direction).containsKey(cellType)) {
            d.get(type).get(direction).put(cellType, Arrays.asList(directions));
        }
    }

    static List<Point> getDirections(int type, char direction, char cellType) {
        return d.get(type).get(direction).get(cellType);
    }

    static {
        d = new HashMap<>();
        add(1, 'u', 'W', new Point[]{new Point(0, 0, 'r')});
        add(1, 'u', 'G', new Point[]{new Point(0, 0, 'r'), new Point(-1, 1, 'u')});
        add(1, 'u', 'B', new Point[]{});
        add(1, 'u', 'b', new Point[]{new Point(-1, -1, 's'), new Point(-2, 0, 's'), new Point(-1, 1, 's')});
        add(1, 'u', 'w', new Point[]{new Point(-1, -1, 's'), new Point(-2, 0, 's'), new Point(-1, 1, 's'), new Point(0, 0, 'r')});
        add(1, 'u', 'D', new Point[]{new Point(-2, 0, 'u')});
        add(1, 'u', 'P', new Point[]{new Point(-2, 0, 'u')});
        add(1, 'u', '.', new Point[]{new Point(-1, 1, 'u')});
        add(1, 'u', ' ', new Point[]{new Point(-1, 1, 'u')});

        add(1, 'l', 'W', new Point[]{new Point(0, 0, 'd')});
        add(1, 'l', 'G', new Point[]{new Point(0, 0, 'd'), new Point(-1, -1, 'l')});
        add(1, 'l', 'B', new Point[]{});
        add(1, 'l', 'b', new Point[]{new Point(-1, -1, 's'), new Point(-2, 0, 's'), new Point(-1, 1, 's')});
        add(1, 'l', 'w', new Point[]{new Point(-1, -1, 's'), new Point(-2, 0, 's'), new Point(-1, 1, 's'), new Point(0, 0, 'd')});
        add(1, 'l', 'D', new Point[]{new Point(-2, 0, 'l')});
        add(1, 'l', 'P', new Point[]{new Point(-2, 0, 'l')});
        add(1, 'l', '.', new Point[]{new Point(-1, -1, 'l')});
        add(1, 'l', ' ', new Point[]{new Point(-1, -1, 'l')});

        add(1, 'r', 'W', new Point[]{new Point(0, 0, 'u')});
        add(1, 'r', 'G', new Point[]{new Point(0, 0, 'u'), new Point(1, 1, 'r')});
        add(1, 'r', 'B', new Point[]{});
        add(1, 'r', 'b', new Point[]{new Point(1, -1, 's'), new Point(2, 0, 's'), new Point(1, 1, 's')});
        add(1, 'r', 'w', new Point[]{new Point(1, -1, 's'), new Point(2, 0, 's'), new Point(1, 1, 's'), new Point(0, 0, 'u')});
        add(1, 'r', 'D', new Point[]{new Point(2, 0, 'r')});
        add(1, 'r', 'P', new Point[]{new Point(2, 0, 'r')});
        add(1, 'r', '.', new Point[]{new Point(1, 1, 'r')});
        add(1, 'r', ' ', new Point[]{new Point(1, 1, 'r')});

        add(1, 'd', 'W', new Point[]{new Point(0, 0, 'l')});
        add(1, 'd', 'G', new Point[]{new Point(0, 0, 'l'), new Point(1, -1, 'd')});
        add(1, 'd', 'B', new Point[]{});
        add(1, 'd', 'b', new Point[]{new Point(1, -1, 's'), new Point(2, 0, 's'), new Point(1, 1, 's')});
        add(1, 'd', 'w', new Point[]{new Point(1, -1, 's'), new Point(2, 0, 's'), new Point(1, 1, 's'), new Point(0, 0, 'l')});
        add(1, 'd', 'D', new Point[]{new Point(2, 0, 'd')});
        add(1, 'd', 'P', new Point[]{new Point(2, 0, 'd')});
        add(1, 'd', '.', new Point[]{new Point(1, -1, 'd')});
        add(1, 'd', ' ', new Point[]{new Point(1, -1, 'd')});

        add(2, 'u', 'W', new Point[]{new Point(0, 0, 'l')});
        add(2, 'u', 'G', new Point[]{new Point(0, 0, 'l'), new Point(-1, 1, 'u')});
        add(2, 'u', 'B', new Point[]{});
        add(2, 'u', 'b', new Point[]{new Point(1, 1, 's'), new Point(0, 2, 's'), new Point(-1, 1, 's')});
        add(2, 'u', 'w', new Point[]{new Point(1, 1, 's'), new Point(0, 2, 's'), new Point(-1, 1, 's'), new Point(0, 0, 'l')});
        add(2, 'u', 'D', new Point[]{new Point(0, 2, 'u')});
        add(2, 'u', 'P', new Point[]{new Point(0, 2, 'u')});
        add(2, 'u', '.', new Point[]{new Point(-1, 1, 'u')});
        add(2, 'u', ' ', new Point[]{new Point(-1, 1, 'u')});

        add(2, 'l', 'W', new Point[]{new Point(0, 0, 'u')});
        add(2, 'l', 'G', new Point[]{new Point(0, 0, 'u'), new Point(-1, -1, 'l')});
        add(2, 'l', 'B', new Point[]{});
        add(2, 'l', 'b', new Point[]{new Point(1, -1, 's'), new Point(0, -2, 's'), new Point(-1, -1, 's')});
        add(2, 'l', 'w', new Point[]{new Point(1, -1, 's'), new Point(0, -2, 's'), new Point(-1, -1, 's'), new Point(0, 0, 'u')});
        add(2, 'l', 'D', new Point[]{new Point(0, -2, 'l')});
        add(2, 'l', 'P', new Point[]{new Point(0, -2, 'l')});
        add(2, 'l', '.', new Point[]{new Point(-1, -1, 'l')});
        add(2, 'l', ' ', new Point[]{new Point(-1, -1, 'l')});

        add(2, 'r', 'W', new Point[]{new Point(0, 0, 'd')});
        add(2, 'r', 'G', new Point[]{new Point(0, 0, 'd'), new Point(1, 1, 'r')});
        add(2, 'r', 'B', new Point[]{});
        add(2, 'r', 'b', new Point[]{new Point(1, 1, 's'), new Point(0, 2, 's'), new Point(-1, 1, 's')});
        add(2, 'r', 'w', new Point[]{new Point(1, 1, 's'), new Point(0, 2, 's'), new Point(-1, 1, 's'), new Point(0, 0, 'd')});
        add(2, 'r', 'D', new Point[]{new Point(0, 2, 'r')});
        add(2, 'r', 'P', new Point[]{new Point(0, 2, 'r')});
        add(2, 'r', '.', new Point[]{new Point(1, 1, 'r')});
        add(2, 'r', ' ', new Point[]{new Point(1, 1, 'r')});

        add(2, 'd', 'W', new Point[]{new Point(0, 0, 'r')});
        add(2, 'd', 'G', new Point[]{new Point(0, 0, 'r'), new Point(1, -1, 'd')});
        add(2, 'd', 'B', new Point[]{});
        add(2, 'd', 'b', new Point[]{new Point(1, -1, 's'), new Point(0, -2, 's'), new Point(-1, -1, 's')});
        add(2, 'd', 'w', new Point[]{new Point(1, -1, 's'), new Point(0, -2, 's'), new Point(-1, -1, 's'), new Point(0, 0, 'r')});
        add(2, 'd', 'D', new Point[]{new Point(0, -2, 'd')});
        add(2, 'd', 'P', new Point[]{new Point(0, -2, 'd')});
        add(2, 'd', '.', new Point[]{new Point(1, -1, 'd')});
        add(2, 'd', ' ', new Point[]{new Point(1, -1, 'd')});
    }
}
