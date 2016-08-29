
public class Main {
    public static void main(String[] args) {
        AdvancedField field = new AdvancedField(3, 4);
        field.addLazer(2, 3, 'u');
        field.addHole(4, 5);
        System.out.println(field);
    }
}
