package tasks.pyramid;

import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        int rowCount = calcRowsCount(inputNumbers.size());
        int colCount = calcColCount(rowCount);

        if(inputNumbers.contains(null)||rowCount==-1){
            throw new CannotBuildPyramidException();
        }
        inputNumbers.sort(Integer::compareTo);

        int step =0;
        int[][] result = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            int padding = calcPadding(i, colCount)-1;
            for (int j = 0; j <= i; j++) {
                result[i][padding+j*2] = inputNumbers.get(step);
                step++;
            }
        }
        return result;
    }

    private int calcRowsCount(int length){
        int result = -1;
        double rowCount = Math.sqrt(1+8*length);
        if(rowCount==(int)rowCount){
            result = ((int) rowCount - 1) / 2;
        }
        return result;
    }
    private int calcColCount(int rows){
        return 2 * rows - 1;
    }
    private int calcPadding(int rowsNumber, int cols){
        return (cols - (2 * rowsNumber - 1)) / 2;
    }

}
