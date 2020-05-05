public class GameOfLife {
    private cellState state;

    public void cell(cellState state){

        this.state = state;
    }

    public static void main(String[] args)
    {
        int M = 10, N = 10;

        // The grid.
        int[][] grid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 }
        };

        // showing/printing the grid
        System.out.println("First Grid");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        newGrid(grid, M, N);
    }

    // to get a new Grid
    static void newGrid(int grid[][], int x, int y)
    {
        int[][] future = new int[x][y];

        // Loop through cells
        for (int a = 1; a < x - 1; a++)
        {
            for (int b  = 1; b  < y - 1; b ++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[a + i][b  + j];

                aliveNeighbours -= grid[a][b ];


                if ((grid[a][b ] == 1) && (aliveNeighbours < 2))
                    future[a][b ] = 0;


                else if ((grid[a][b ] == 1) && (aliveNeighbours > 3))
                    future[a][b ] = 0;


                else if ((grid[a][b ] == 0) && (aliveNeighbours == 3))
                    future[a][b ] = 1;


                else
                    future[a][b ] = grid[a][b ];
            }
        }

        System.out.println("Next Grid");
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    public cellState GetState(int i) {
        return i > 1  && i < 4 ? cellState.ALIVE : cellState.DEAD;
    }

    public enum cellState {
        ALIVE, DEAD
    }
}
