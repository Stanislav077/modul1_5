public class Main {

    public static void main(String[] args) {
        Horse array = new Horse();
        array.init();
        System.out.println(array);
        array.moveTo();
        System.out.println("S-Стартовая позиция\nК-возможные варианты хода коня");
        System.out.println(array);

    }
}
