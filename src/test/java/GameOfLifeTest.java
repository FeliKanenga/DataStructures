

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

        @Test
        public void GetNextState(){
            GameOfLife game = new GameOfLife();
            Assert.assertEquals(game.GetNextState(2), GameOfLife.CellState.ALIVE);

        }

}