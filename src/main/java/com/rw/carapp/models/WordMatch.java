package com.rw.carapp.models;

public class WordMatch {

  private String word;
  private short score;
  private short numSyllables;

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public short getScore() {
    return score;
  }

  public void setScore(short score) {
    this.score = score;
  }

  public short getNumSyllables() {
    return numSyllables;
  }

  public void setNumSyllables(short numSyllables) {
    this.numSyllables = numSyllables;
  }
}