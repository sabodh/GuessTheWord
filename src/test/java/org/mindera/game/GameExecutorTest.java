package org.mindera.game;
import org.junit.Test;
import org.mindera.user.UserPrompt;
import org.mockito.Mockito;
public class GameExecutorTest {


    @Test
    public void test_user_guess_the_character_properly(){
        UserPrompt prompt = Mockito.mock(UserPrompt.class);
        GameExecutor executor = new GameExecutor(prompt, NumberOfLives.SHORT);
        Mockito.when(prompt.getCharacter()).thenReturn('c','a','r');
        executor.playGame("car");
    }
    @Test
    public void test_user_guess_the_wrong_attempts()  {
        UserPrompt prompt = Mockito.mock(UserPrompt.class);
        GameExecutor executor = new GameExecutor(prompt, NumberOfLives.SHORT);
        Mockito.when(prompt.getCharacter()).thenReturn('t','m');
        executor.playGame("car");
    }

}