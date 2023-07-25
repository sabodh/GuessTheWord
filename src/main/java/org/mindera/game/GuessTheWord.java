package org.mindera.game;


import org.mindera.repository.WordRepository;
import org.mindera.repository.WordRepositoryImpl;
import org.mindera.user.UserPrompt;

public class GuessTheWord {

    public static void main(String[] args) {
        // Creating repository
        WordRepository repository = new WordRepositoryImpl();
        // create user input prompt
        UserPrompt userPrompt = new UserPrompt();
        // creating executor object
        GameExecutor executor = new GameExecutor(userPrompt, NumberOfLives.MEDIUM);
        // variable used to handle game iterations
        boolean continuePlay = true;
        try {
            while (continuePlay) {
                System.out.println("Game Started");
                // get random word from repository
                String selectedWord = repository.getWord();
                // invoking game using random word
                executor.playGame(selectedWord);
                System.out.println("Do you want continue(y/n)");
                if (userPrompt.getCharacter() == 'n') {
                    continuePlay = false;
                }
            }
        } catch (Exception message) {
            System.out.println(message.toString());
        }

    }
}
