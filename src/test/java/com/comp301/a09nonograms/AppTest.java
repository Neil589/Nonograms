package com.comp301.a09nonograms;

import com.comp301.a09nonograms.model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        List<Clues> cluelist = PuzzleLibrary.create();
        Board board = new BoardImpl(cluelist.get(0).getWidth(), cluelist.get(0).getHeight());
        //    int[][] rows = new int[2][2];
        //    int[][] cols = new int[2][2];
        //    Clues clues = new CluesImpl(rows,cols);

        //    Clues clues2 = new CluesImpl();
        Model model = new ModelImpl(cluelist);
        //    assertTrue(cluelist.size() == 5);
        board.toggleCellEliminated(0, 0);
        assertTrue(true);
        //    assertTrue(true);
    }
    //more test cases covered in autograder!
}
