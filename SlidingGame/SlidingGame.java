import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Nayeong Kim (s1006313)
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    private int[][] board;
    private int holeX;
    private int holeY;
    private int manhattanDistance;
    private Configuration parent;
    private Collection<Configuration> visitedHash;

    public SlidingGame(int[] start) {
        board = new int[N][N];
        manhattanDistance = 0;
        visitedHash = new HashSet<>();

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }

    public SlidingGame(int[][] start, int holeX, int holeY, int manhattanDistance, Configuration parent, Collection visitedHash) {
        this.board = start;
        this.parent = parent;
        this.holeX = holeX;
        this.holeY = holeY;
        this.manhattanDistance = manhattanDistance;
        this.visitedHash = visitedHash;
    }

    private boolean isLegal(Direction direction) {
        switch (direction) {
            case NORTH:
                return holeY > 0;
            case SOUTH:
                return holeY < N - 1;
            case WEST:
                return holeX > 0;
            case EAST:
                return holeX < N - 1;
        }
        return false;
    }

    private Configuration calculateSuccessor(Direction direction) {

        int[][] copiedBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedBoard[i][j] = board[i][j];
            }
        }

        int newXpos = holeX + direction.GetDX();
        int newYpos = holeY + direction.GetDY();
        int value = board[newXpos][newYpos];

        Configuration newPuzzle = new SlidingGame(copiedBoard, newXpos, newYpos, this.manhattanDistance + 1, this, visitedHash);

        newPuzzle.getBoard()[holeX][holeY] = value;
        newPuzzle.getBoard()[newXpos][newYpos] = HOLE;

        return newPuzzle;
    }

    @Override
    public int getManhattanDistance() {
        return this.manhattanDistance;
    }

    @Override
    public int[][] getBoard() {
        return this.board;
    }

    @Override
    public boolean equals(Object o) {
        SlidingGame game = (SlidingGame) o;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!(board[j][i] == game.board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int compareTo(Configuration g) {
        return this.manhattanDistance - g.getManhattanDistance();
    }

    @Override
    public Configuration parent() {
        return this.parent;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public int hashCode() {
        int hashValue = 0;
        for (int x = N - 1; x >= 0; x--) {
            for (int y = N - 1; y >= 0; y--) {
                hashValue = 31 * hashValue + board[x][y];
            }
        }
        return hashValue;
    }

    @Override
    public boolean isSolution() {
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[j][i] != count) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            if (isLegal(direction)) {
                Configuration successor = calculateSuccessor(direction);

                if (!(visitedHash.contains(successor))) {
                    successors.add(successor);
                    visitedHash.add(successor);
                }

            }

        }
        return successors;

    }

}
