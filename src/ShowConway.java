public class ShowConway {
    public static void drawGame(boolean[] cells, int size, int width) {
        System.out.print("\n\n\n\n");
        for (int i = 0; i < size; i++) {
            if (i % width == 0) {
                System.out.print("\n");
            }

            if (cells[i]) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
    }
    public static void main(String [] args)
    {
        Conway conway = new Conway(10, 10);
        conway.randomizeCells();
        while (true) {
            drawGame(conway.getCells(), conway.getSize(), conway.getWidth());
            conway.tick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
