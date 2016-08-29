import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdvancedField {

    int l;
    int c;
    char[][] field;
    List<Laser> lasers;
    List<Hole> holes;

    public AdvancedField(int l, int c) {
        this.l = l * 2 + 1;
        this.c = c * 2 + 1;
        lasers = new ArrayList<>();
        holes = new ArrayList<>();
        field = new char[this.l][];

        for (int i = 0; i < this.l; i++) {
            field[i] = new char[this.c];
        }

        for (int i = 0; i < this.l; i++) {
            for (int j = 0; j < this.c; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    field[i][j] = '+';
                    continue;
                }
                if (i % 2 == 0) {
                    field[i][j] = '-';
                    continue;
                }
                if (j % 2 == 0) {
                    field[i][j] = '|';
                    continue;
                }
                field[i][j] = ' ';
            }
        }
    }

    public void addLazer(int x, int y, char direction) {
        lasers.add(new Laser(x, y, direction));
        field[x][y] = direction;
    }

    public void addHole(int x, int y) {
        holes.add(new Hole(x, y));
        field[x][y] = 'o';
    }

    boolean check() {
        return check(false);
    }

    boolean check(boolean change){
        boolean[] checked = new boolean[holes.size()];
        for(int i = 0; i < checked.length; i++) {
            checked[i] = false;
        }

        for (Laser laser : lasers) {

        }



        for (boolean c : checked) {
            if (!c) {
                return false;
            }
        }
        return true;
    }

    List<Integer> checkLaser(Laser laser) {
        return checkDirection(laser.x, laser.y, laser, laser.direction, true);
    }

    List<Integer> checkDirection(int x, int y, Laser l, char d){
        return checkDirection(x, y, l, d, false);
    }

    List<Integer> checkDirection(int x, int y, Laser l, char d, boolean first){
        List<Integer> res = new ArrayList<>();

        if (!first && l.x == x && l.y == y && l.direction == d) {
            return res;
        }

        if (field[x][y] == 'o') {
            res.add(getHoleNumber(x, y));
        }

        int cx = -1;
        int cy = -1;
        int c = -1;
        if (x % 2 == 0) {
            c = 1;
            cx = x + 1;
            cy = y;
            if (d == 'u' || d == 'l') {
                cx = x - 1;
            }
        } else {
            if (y % 2 == 0) {
                c = 2;
                cx = x;
                cy = y - 1;
                if (d == 'u' || d == 'r') {
                    cy = y + 1;
                }
            } else {
                throw new RuntimeException();
            }
        }

        if (cx < 0 || cy < 0 || cx >= this.l || cy >= this.c) {
            return res;
        }

        if (field[cx][cy] == 'D') {
            return res;
        }



        return res;
    }

    int getHoleNumber(int x, int y) {
        for (int i = 0; i < holes.size(); i++) {
            if (holes.get(i).x == x && holes.get(i).y == y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String res = "";
        for (char[] line : field) {
            for (char point : line) {
                res += point;
            }
            res += "\n";
        }
        return res;
    }
}
