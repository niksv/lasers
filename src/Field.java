import java.util.*;

class Field {

    int l;
    int c;
    char[][] field;
    private List<Point> lasers;
    private List<Hole> holes;

    Field(int l, int c) {
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

    void addLazer(int x, int y, char direction) {
        lasers.add(new Point(x, y, direction));
        field[x][y] = direction;
    }

    void addHole(int x, int y) {
        holes.add(new Hole(x, y));
        field[x][y] = 'o';
    }

    boolean check(){
        Set<Integer> checked = new HashSet<>();


        for (Point laser : lasers) {
            checked.addAll(checkLaser(laser));
        }

        if (checked.size() != holes.size()) {
            return false;
        }

        for (int i = 0; i < holes.size(); i++) {
            if (!checked.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private Set<Integer> checkLaser(Point laser) {
        return checkDirection(laser.x, laser.y, new ArrayList<>(), laser.direction);
    }

    private Set<Integer> checkDirection(int x, int y, List<Point> previous, char d){
        Set<Integer> res = new HashSet<>();

        for (Point p : previous) {
            if (p.x == x && p.y == y && p.direction == d) {
                return res;
            }
        }
        previous.add(new Point(x, y, d));

        if (field[x][y] == 'o') {
            res.add(getHoleNumber(x, y));
        }

        if (d == 's') {
            return res;
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

        int startX = x;
        int startY = y;

        if (field[cx][cy] == 'P') {
            Point secondPortal = getSecondPortal(cx, cy);
            startX += secondPortal.x - cx;
            startY += secondPortal.y - cy;
        }

        for (Point direction : Directions.getDirections(c, d, field[cx][cy])) {
            res.addAll(checkDirection(startX + direction.x, startY + direction.y, previous, direction.direction));
        }

        return res;
    }

    private Point getSecondPortal(int x, int y) {
        for (int i = 1; i < l; i += 2) {
            for (int j = 1; j < c; j += 2) {
                if (field[i][j] == 'P' && !(i == x && j == y)) {
                    return new Point(i, j, 'P');
                }
            }
        }

        return null;
    }

    private int getHoleNumber(int x, int y) {
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
