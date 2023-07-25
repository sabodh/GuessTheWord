package org.mindera.game;

import org.mindera.user.UserPrompt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameExecutor implements Game {

    private final UserPrompt userPrompt;
    private String maskedWord;
    private String selectedWord;
    // Used to store user inputs(characters)
    private Set<Character> userEntries;

    private int life;
    private NumberOfLives numberOfLives;

    private boolean gameOn;

    public GameExecutor(UserPrompt userPrompt, NumberOfLives life) {
        this.userPrompt = userPrompt;
        this.userEntries = new HashSet<>();
        this.numberOfLives = life;
    }

    /**
     * Game start here
     *
     * @param selectedWord - random selected word
     */
    @Override
    public void playGame(String selectedWord) {
        initialiseGame(selectedWord);
        while (gameOn) {
            System.out.println("Guess the word: " + maskedWord);
            Character selectedCharacter = userPrompt.getCharacter();
            this.maskedWord = execute(maskedWord, selectedCharacter);
            if (isGameOn()) {
                gameOn = validateLives();
            }
        }
    }

    /**
     * Method of assign initial values, mask the selected word and life of game
     *
     * @param selectedWord - random selected word
     */
    private void initialiseGame(String selectedWord) {
        this.selectedWord = selectedWord;
        this.maskedWord = mask(selectedWord);
        this.life = numberOfLives.getLife();
        this.gameOn = true;
    }

    /**
     * Executing the game logic
     *
     * @param masked     masked  word
     * @param userPrompt user input character
     * @return - masked word after the process
     */
    private String execute(String masked, Character userPrompt) {
        if (userEntries.contains(userPrompt)) {
            System.out.println("You already tried this letter.");
            return masked;
        } else {
            // get the new masked word after the evaluation
            String evaluatedWord = validate(userPrompt);
            if (evaluatedWord.equals(selectedWord)) {
                System.out.println("Congratulations! You have won the game.");
                resetGame();
                return evaluatedWord;
            }// no new character added in the existing masked word.
            else if (evaluatedWord.equals(masked)) {
                storeUserPrompt(userPrompt);
                reduceLife();
                System.out.println("Incorrect 1 life lost. " + life + " remaining. " +
                        "The current word is : " + masked);
                return evaluatedWord;
            } else {
                System.out.println("Correct : " + evaluatedWord);
                storeUserPrompt(userPrompt);
                return evaluatedWord;
            }
        }
    }

    /**
     * Store user entries for validation
     *
     * @param character - user entered character
     */
    private void storeUserPrompt(Character character) {
        userEntries.add(character);
    }


    /**
     * Mask the random word
     *
     * @param selectedString - random word
     * @return - masked word
     */

    private String mask(String selectedString) {
        if (selectedString.isEmpty()) {
            return "";
        } else {
            return "*".repeat(selectedString.length());
        }
    }

    /**
     * Reducing the user life after each attempts
     */
    private void reduceLife() {
        life--;
    }

    /**
     * Validate the character present in the random selected word
     * and replace the new character in the masked word
     *
     * @param selectedCharacter - user input character
     * @return - new masked word after the character replacement
     */

    private String validate(Character selectedCharacter) {
        int index = getIndex(selectedCharacter);
        return replaceCharAtIndex(maskedWord, index, selectedCharacter);
    }

    /**
     * Reset variables before starting new game
     */

    private void resetGame() {
        userEntries.clear();
        gameOn = false;
        maskedWord = selectedWord;
    }

    /**
     * Check the un-msked word and random selected words are equals,
     * if equals the game is completed.
     *
     * @return - status of the game - true or false
     */
    private boolean isGameOn() {
        return !(selectedWord.equals(maskedWord));
    }

    /**
     * Validate the life is available for the next iteration
     *
     * @return - status of the life - true or false
     */

    private boolean validateLives() {
        if (life == 0) {
            System.out.println("You lost all your lives: Correct Word is: " + selectedWord);
            return false;
        }
        return true;
    }

    /**
     * Get index of the character from the given word
     *
     * @param selectedCharacter - random selected word
     * @return - index of the character
     */
    private int getIndex(Character selectedCharacter) {
        return selectedWord.indexOf(selectedCharacter);
    }

    /**
     * Replace the character in the masked word using index
     *
     * @param selectedWord    - selected masked word
     * @param index           - index of the character
     * @param replacementChar - character need to add
     * @return - new word with replaced character
     */
    private String replaceCharAtIndex(String selectedWord, int index, char replacementChar) {
        if (index < 0 || index >= selectedWord.length()) {
            return selectedWord;
        }
        return IntStream.range(0, selectedWord.length())
                .mapToObj(i -> (i == index) ? replacementChar : selectedWord.charAt(i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
