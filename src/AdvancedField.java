import java.util.Arrays;

public class AdvancedField {
    int l;
    int c;
    char[][] field;

    public AdvancedField(int l, int c) {
        this.l = l * 2 + 1;
        this.c = c * 2 + 1;
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
