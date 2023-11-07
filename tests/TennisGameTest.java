import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TennisGameTest {
	private TennisGame game;
	
	
	

    @Before
    public void setUp() {
        game = new TennisGame();
    }
	

	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	
	
	@Test
    public void testInitialScore() {
        assertEquals("love - love", game.getScore());
    }

    @Test
    public void testPlayer1Scores() throws TennisGameException {
        game.player1Scored();
        assertEquals("15 - love", game.getScore());
    }

    @Test
    public void testPlayer2Scores() throws TennisGameException {
        game.player2Scored();
        assertEquals("love - 15", game.getScore());
    }

    @Test
    public void testDeuce() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        assertEquals("deuce", game.getScore());
    }

    @Test
    public void testAdvantagePlayer1() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        assertEquals("player1 has advantage", game.getScore());
    }

    @Test
    public void testAdvantagePlayer2() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        assertEquals("player2 has advantage", game.getScore());
    }

    @Test
    public void testPlayer1Wins() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        assertEquals("player1 wins", game.getScore());
    }

    @Test
    public void testPlayer2Wins() throws TennisGameException {
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        assertEquals("player2 wins", game.getScore());
    }

   
    //MUTATIONS
    
    
    
    
    @Test
    public void testGetScoreForPoints() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TennisGame game = new TennisGame();

        try {
            Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
            getScoreMethod.setAccessible(true);

            // Test for points 0, 1, 2, 3
            assertEquals("love", getScoreMethod.invoke(game, 0));
            assertEquals("15", getScoreMethod.invoke(game, 1));
            assertEquals("30", getScoreMethod.invoke(game, 2));
            assertEquals("40", getScoreMethod.invoke(game, 3));

            // Test for an out-of-range value (e.g., -1)
            assertEquals("love", getScoreMethod.invoke(game, 0));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
   
    
    
    

}
