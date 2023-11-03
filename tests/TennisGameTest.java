import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;

public class TennisGameTest {
    private TennisGame game;

    @Before
    public void setUp() {
        game = new TennisGame();
    }

    @Test
    public void testInitialScore() {
        assertEquals("Initial score should be 'love - love'", "love - love", game.getScore());
    }

    @Test
    public void testPlayer1Wins() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        assertEquals("Player1 should win", "player1 wins", game.getScore());
    }

    @Test
    public void testPlayer2Wins() throws TennisGameException {
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        assertEquals("Player2 should win", "player2 wins", game.getScore());
    }

    @Test
    public void testGetScoreDeuce() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored(); // Deuce

        assertEquals("The score should be 'deuce'", "deuce", game.getScore());
    }
    
    
    @Test
    public void testPlayer2Scored() throws TennisGameException {
        game.player2Scored();
        assertEquals("Score should be 'love - 15'", "love - 15", game.getScore());
    }
    
    
    
    @Test
    public void testGetScorePlayer1Wins() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        assertEquals("Player 1 should win", "player1 wins", game.getScore());
    }
    
    
    @Test
    public void testGetScorePlayer2Advantage() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored(); // Player 2 has advantage
        assertEquals("Player 2 should have advantage", "player2 has advantage", game.getScore());
    }

    @Test
    public void testGetScorePlayer1Advantage() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player1Scored(); // Player 1 has advantage
        assertEquals("Player 1 should have advantage", "player1 has advantage", game.getScore());
    }

    
    @Test
    public void testGetScoreLove() throws Exception {
        Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
        getScoreMethod.setAccessible(true);

        String score = (String) getScoreMethod.invoke(game, 0);

        assertEquals("0 points should be 'love'", "love", score);
    }

    @Test
    public void testGetScoreFifteen() throws Exception {
        Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
        getScoreMethod.setAccessible(true);

        String score = (String) getScoreMethod.invoke(game, 1);

        assertEquals("1 point should be '15'", "15", score);
    }

    @Test
    public void testGetScoreThirty() throws Exception {
        Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
        getScoreMethod.setAccessible(true);

        String score = (String) getScoreMethod.invoke(game, 2);

        assertEquals("2 points should be '30'", "30", score);
    }

    @Test
    public void testGetScoreForty() throws Exception {
        Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
        getScoreMethod.setAccessible(true);

        String score = (String) getScoreMethod.invoke(game, 3);

        assertEquals("3 points should be '40'", "40", score);
    }

    @Test
    public void testGetScoreDefault() throws Exception {
        Method getScoreMethod = TennisGame.class.getDeclaredMethod("getScore", int.class);
        getScoreMethod.setAccessible(true);

        String score = (String) getScoreMethod.invoke(game, 4);

        assertEquals("Any other point value should be '40'", "40", score);
    }

    
    
   

    @Test
    public void testInvalidScoring() {
        try {
            game.player1Scored();
            game.player1Scored();
            game.player1Scored();
            game.player1Scored();
            game.player1Scored(); // This should throw an exception
            fail("Expected TennisGameException");
        } catch (TennisGameException e) {
            // This is expected
        }
    }

    
    
    
    
    
    
    
    
   
    
    
    @Test
    public void testAdvantage() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player1Scored();

       assertEquals("Player1 should have advantage", "player1 has advantage", game.getScore());
    }

    

    @Test
    public void testPlayer2ScoredGameEnded() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        // Player 1 has won, the game is over

        try {
            game.player2Scored(); // This should throw an exception
            fail("Expected TennisGameException");
        } catch (TennisGameException e) {
            // This is expected
        }
    }
    
    
    @Test
    public void testGetScorePlayer2Wins() throws TennisGameException {
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        assertEquals("Player 2 should win", "player2 wins", game.getScore());
    }

    
    
    
    
    @Test
    public void testInvalidScoringAtDeuce() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();

        try {
            game.player1Scored(); // This should throw an exception
            fail("Expected TennisGameException");
        } catch (TennisGameException e) {
            // This is expected
        }
    }
}








/* Alkuperaiset testis 
 * 
 

    @Before
    public void setUp() {
        game = new TennisGame();
    }

    @Test
    public void testInitialScore() {
        assertEquals("Initial score should be 'love - love'", "love - love", game.getScore());
    }

    @Test
    public void testPlayer1Wins() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();

        assertEquals("Player1 should win", "player1 wins", game.getScore());
    }

    @Test
    public void testPlayer2Wins() throws TennisGameException {
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();

        assertEquals("Player2 should win", "player2 wins", game.getScore());
    }

    @Test
    public void testGetScoreDeuce() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored(); // Deuce

        assertEquals("The score should be 'deuce'", "deuce", game.getScore());
    }
    
    
    @Test
    public void testPlayer2Scored() throws TennisGameException {
        game.player2Scored();
        assertEquals("Score should be 'love - 15'", "love - 15", game.getScore());
    }
    
    
    
    @Test
    public void testGetScorePlayer1Wins() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        assertEquals("Player 1 should win", "player1 wins", game.getScore());
    }
    
    


    
    
    
    
    
    @Test
    public void testGetScorePlayer2Advantage() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored(); // Player 2 has advantage
        assertEquals("Player 2 should have advantage", "player2 has advantage", game.getScore());
    }

    
    @Test
    public void testGetScorePlayer1Advantage() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player1Scored(); // Player 1 has advantage
        assertEquals("Player 1 should have advantage", "player1 has advantage", game.getScore());
    }
    
    
    
    @Test
    public void testAdvantage() throws TennisGameException {
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player1Scored();

       assertEquals("Player1 should have advantage", "player1 has advantage", game.getScore());
    }

    

    @Test
    public void testPlayer2ScoredGameEnded() throws TennisGameException {
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        // Player 1 has won, the game is over

        try {
            game.player2Scored(); // This should throw an exception
            fail("Expected TennisGameException");
        } catch (TennisGameException e) {
            // This is expected
        }
    }
    
    
    @Test
    public void testGetScorePlayer2Wins() throws TennisGameException {
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        assertEquals("Player 2 should win", "player2 wins", game.getScore());
    }

    
    
    
    
    
    @Test
    public void testInvalidScoring() {
        try {
            game.player1Scored();
            game.player1Scored();
            game.player1Scored();
            game.player1Scored();
            game.player1Scored(); // This should throw an exception
            fail("Expected TennisGameException");
        } catch (TennisGameException e) {
            // This is expected
        }
    }
}


*/
