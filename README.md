# Guess The Word

Guess The Word is  a single player “Guess the word” game against the computer
- At the start of the game the computer should pick a random word from a
predetermined list. The word should be shown to the user but with all letters blanked
out with an asterix
- The user should be prompted to enter a letter (don’t worry too much about capturing
the user input - think about how this can be generalised)
- The user gets feedback if they have correctly guessed a letter from the word
- If they have then the word is shown with all letters correctly guessed so far,
all other letters are blanked out with an asterix
- If they get it wrong then they lose a life
The game then continues with the user continuing to guess letters until 
They guess the entire word and win the game They run out of lives and the computer wins the game. 
The number of lives can be hard coded


#### Classes
- GuessTheWord.java - main class for execution starts
- Game.java - Game features
- GameExecutor.java - game logic 
- Words.java - data class for words
- NumberOfLives.java - Enum class for Number of lives
- WordRepository.java - provider for random words
- Prompt.java - provider for user input

#### Test Classes

- GameExecutorTest.java

##### Test methods 
- test_user_guess_the_character_properly() - check the user guess is valid
- test_user_guess_the_wrong_attempts() - test user multiple wrong guess

Limitations

1. User enter the wrong character second time will not reduce the life
2. Game capture only first index of the character of the word, if the word has repeated character will not work.(Eg: book, eye).
### Class diagrams
![diagram 1](/diagram/GuessTheWord.png)

![diagram 1](/diagram/GuessTheWord_file_1.png)


- SDK Used - Java 17
- maven wrapper created for execution

prerequisites
Java 17
Maven 





