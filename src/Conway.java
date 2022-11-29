import java.util.Random;

public class Conway {
    private final int width;
    private final int height;
    private final int size;
    private boolean[] cells;

    public Conway(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.cells = new boolean[size];
    }

    public void randomizeCells() {
        Random random = new Random();
        for (int i = 0; i < this.size ; i++) {
            this.cells[i] = random.nextBoolean();
        }
    }
    public int getIndex(int row, int column) {
        return row * width + column;
    }
    public int countLiveNeighbors(int row, int column) {
        int count = 0;
        for (int delta_row = -1; delta_row < 2; delta_row++) {
            for (int delta_col = -1; delta_col < 2; delta_col++) {
                if (delta_row == 0 && delta_col == 0) {
                    continue;
                }
                int neighbor_row = Math.floorMod( row + delta_row,  height);
                int neighbor_col = Math.floorMod(column + delta_col, width);
                int idx = getIndex(neighbor_row, neighbor_col);
                if (cells[idx]) {
                    count++;
                }
            }
        }
        return count;
    }
    public void tick() {
        boolean[] next = new boolean[size];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int idx = getIndex(row, col);
                int live_neighbors = countLiveNeighbors(row, col);
                boolean cell_state = cells[idx];
                boolean new_cell_state;
                if (cell_state && (live_neighbors == 2 || live_neighbors == 3)) {
                    new_cell_state = true;
                } else if (!cell_state && live_neighbors == 3) {
                    new_cell_state =  true;
                } else {
                    new_cell_state = false;
                }
                next[idx] = new_cell_state;
            }
        }
        this.cells = next;
    }

    public boolean[] getCells() {
        return cells;
    }
    public int getSize() {
        return size;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
