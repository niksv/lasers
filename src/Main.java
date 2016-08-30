
public class Main {
    public static void main(String[] args) {
        AdvancedField field = new AdvancedField(3, 4);
        field.addLazer(2, 3, 'r');
        field.addHole(4, 5);
        field.addHole(6, 3);
        field.field[3][5] = 'G';
        field.field[3][3] = 'W';
        field.field[1][3] = 'W';
        System.out.println(field);
        System.out.println(field.check());
    }
}
