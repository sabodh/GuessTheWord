package org.mindera.game;

/**
 * Used for handling Life details
 */
public enum NumberOfLives {
    LONG(6),
    MEDIUM(4),
    SHORT(2);
    private final int life;
    NumberOfLives(int life){
        this.life = life;
    }
    public int getLife(){
        return life;
    }
}
