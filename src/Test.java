public class Test {
    public static void main(String [] args)
    {
        Conway conway = new Conway(50, 50);
        conway.randomizeCells();
        conway.tick();
    }
}
