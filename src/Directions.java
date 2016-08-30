import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directions {
    public static Map<Integer, Map<Character, Map<Character, List<Laser>>>> d;
    public static void add(int type, char direction, char cellType, Laser[] directions) {
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

    public static List<Laser> getDirections(int type, char direction, char cellType) {
        return d.get(type).get(direction).get(cellType);
    }

    static {
        d = new HashMap<>();
        add(1, 'u', 'W', new Laser[]{new Laser(0, 0, 'r')});
        add(1, 'u', 'G', new Laser[]{new Laser(0, 0, 'r'), new Laser(-1, 1, 'u')});
        add(1, 'u', 'B', new Laser[]{});
        add(1, 'u', 'b', new Laser[]{new Laser(-1, -1, 's'), new Laser(-2, 0, 's'), new Laser(-1, 1, 's')});
        add(1, 'u', 'w', new Laser[]{new Laser(-1, -1, 's'), new Laser(-2, 0, 's'), new Laser(-1, 1, 's'), new Laser(0, 0, 'r')});
        add(1, 'u', 'D', new Laser[]{new Laser(-2, 0, 'u')});
        add(1, 'u', '.', new Laser[]{new Laser(-1, 1, 'u')});
        add(1, 'u', ' ', new Laser[]{new Laser(-1, 1, 'u')});

        add(1, 'l', 'W', new Laser[]{new Laser(0, 0, 'd')});
        add(1, 'l', 'G', new Laser[]{new Laser(0, 0, 'd'), new Laser(-1, -1, 'l')});
        add(1, 'l', 'B', new Laser[]{});
        add(1, 'l', 'b', new Laser[]{new Laser(-1, -1, 's'), new Laser(-2, 0, 's'), new Laser(-1, 1, 's')});
        add(1, 'l', 'w', new Laser[]{new Laser(-1, -1, 's'), new Laser(-2, 0, 's'), new Laser(-1, 1, 's'), new Laser(0, 0, 'd')});
        add(1, 'l', 'D', new Laser[]{new Laser(-2, 0, 'l')});
        add(1, 'l', '.', new Laser[]{new Laser(-1, -1, 'l')});
        add(1, 'l', ' ', new Laser[]{new Laser(-1, -1, 'l')});

        add(1, 'r', 'W', new Laser[]{new Laser(0, 0, 'u')});
        add(1, 'r', 'G', new Laser[]{new Laser(0, 0, 'u'), new Laser(1, 1, 'r')});
        add(1, 'r', 'B', new Laser[]{});
        add(1, 'r', 'b', new Laser[]{new Laser(1, -1, 's'), new Laser(2, 0, 's'), new Laser(1, 1, 's')});
        add(1, 'r', 'w', new Laser[]{new Laser(1, -1, 's'), new Laser(2, 0, 's'), new Laser(1, 1, 's'), new Laser(0, 0, 'u')});
        add(1, 'r', 'D', new Laser[]{new Laser(2, 0, 'r')});
        add(1, 'r', '.', new Laser[]{new Laser(1, 1, 'r')});
        add(1, 'r', ' ', new Laser[]{new Laser(1, 1, 'r')});

        add(1, 'd', 'W', new Laser[]{new Laser(0, 0, 'l')});
        add(1, 'd', 'G', new Laser[]{new Laser(0, 0, 'l'), new Laser(1, -1, 'd')});
        add(1, 'd', 'B', new Laser[]{});
        add(1, 'd', 'b', new Laser[]{new Laser(1, -1, 's'), new Laser(2, 0, 's'), new Laser(1, 1, 's')});
        add(1, 'd', 'w', new Laser[]{new Laser(1, -1, 's'), new Laser(2, 0, 's'), new Laser(1, 1, 's'), new Laser(0, 0, 'l')});
        add(1, 'd', 'D', new Laser[]{new Laser(2, 0, 'd')});
        add(1, 'd', '.', new Laser[]{new Laser(1, -1, 'd')});
        add(1, 'd', ' ', new Laser[]{new Laser(1, -1, 'd')});

        add(2, 'u', 'W', new Laser[]{new Laser(0, 0, 'l')});
        add(2, 'u', 'G', new Laser[]{new Laser(0, 0, 'l'), new Laser(-1, 1, 'u')});
        add(2, 'u', 'B', new Laser[]{});
        add(2, 'u', 'b', new Laser[]{new Laser(1, 1, 's'), new Laser(0, 2, 's'), new Laser(-1, 1, 's')});
        add(2, 'u', 'w', new Laser[]{new Laser(1, 1, 's'), new Laser(0, 2, 's'), new Laser(-1, 1, 's'), new Laser(0, 0, 'l')});
        add(2, 'u', 'D', new Laser[]{new Laser(0, 2, 'u')});
        add(2, 'u', '.', new Laser[]{new Laser(-1, 1, 'u')});
        add(2, 'u', ' ', new Laser[]{new Laser(-1, 1, 'u')});

        add(2, 'l', 'W', new Laser[]{new Laser(0, 0, 'u')});
        add(2, 'l', 'G', new Laser[]{new Laser(0, 0, 'u'), new Laser(-1, -1, 'l')});
        add(2, 'l', 'B', new Laser[]{});
        add(2, 'l', 'b', new Laser[]{new Laser(1, -1, 's'), new Laser(0, -2, 's'), new Laser(-1, -1, 's')});
        add(2, 'l', 'w', new Laser[]{new Laser(1, -1, 's'), new Laser(0, -2, 's'), new Laser(-1, -1, 's'), new Laser(0, 0, 'u')});
        add(2, 'l', 'D', new Laser[]{new Laser(0, -2, 'l')});
        add(2, 'l', '.', new Laser[]{new Laser(-1, -1, 'l')});
        add(2, 'l', ' ', new Laser[]{new Laser(-1, -1, 'l')});

        add(2, 'r', 'W', new Laser[]{new Laser(0, 0, 'd')});
        add(2, 'r', 'G', new Laser[]{new Laser(0, 0, 'd'), new Laser(1, 1, 'r')});
        add(2, 'r', 'B', new Laser[]{});
        add(2, 'r', 'b', new Laser[]{new Laser(1, 1, 's'), new Laser(0, 2, 's'), new Laser(-1, 1, 's')});
        add(2, 'r', 'w', new Laser[]{new Laser(1, 1, 's'), new Laser(0, 2, 's'), new Laser(-1, 1, 's'), new Laser(0, 0, 'd')});
        add(2, 'r', 'D', new Laser[]{new Laser(0, 2, 'r')});
        add(2, 'r', '.', new Laser[]{new Laser(1, 1, 'r')});
        add(2, 'r', ' ', new Laser[]{new Laser(1, 1, 'r')});

        add(2, 'd', 'W', new Laser[]{new Laser(0, 0, 'r')});
        add(2, 'd', 'G', new Laser[]{new Laser(0, 0, 'r'), new Laser(1, -1, 'd')});
        add(2, 'd', 'B', new Laser[]{});
        add(2, 'd', 'b', new Laser[]{new Laser(1, -1, 's'), new Laser(0, -2, 's'), new Laser(-1, -1, 's')});
        add(2, 'd', 'w', new Laser[]{new Laser(1, -1, 's'), new Laser(0, -2, 's'), new Laser(-1, -1, 's'), new Laser(0, 0, 'r')});
        add(2, 'd', 'D', new Laser[]{new Laser(0, -2, 'd')});
        add(2, 'd', '.', new Laser[]{new Laser(1, -1, 'd')});
        add(2, 'd', ' ', new Laser[]{new Laser(1, -1, 'd')});
    }
}
