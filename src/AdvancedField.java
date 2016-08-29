import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    List<Integer> checkLaser(Laser laser){
        return null;
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
