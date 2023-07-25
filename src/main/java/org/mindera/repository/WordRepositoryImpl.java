package org.mindera.repository;

import org.mindera.model.Word;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordRepositoryImpl implements WordRepository {
    // Create multiple word list.
    static List<Word> wordList = Arrays.asList(new Word("cable"),
            new Word("car"),
            new Word("phone"),
            new Word("bus"));

    // Return Random word from the word list.
    @Override
    public String getWord() {
        return wordList.get(new Random().nextInt(wordList.size())).word();
    }


}
