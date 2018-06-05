package com.pklein.gradle.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {
    public String getJoke() {

        List<String> ListJokes = new ArrayList<>();
        ListJokes.add("What do you call a pile of kittens ?\n\n A meowntain");
        ListJokes.add("When do you go at red and stop at green ?\n\n When you are eating a watermelon");
        ListJokes.add("Why don't cats play poker in the jungle ?\n\n Too many cheetahs");
        ListJokes.add("Why shouldn't you give Elsa a balloon ?\n\n Because she will let it go !");
        ListJokes.add("What do cats like to eat for breakfast ?\n\n  Mice Krispies");

        Random randomJoke = new Random();
        int randomIntJoke = randomJoke.nextInt(ListJokes.size());
        return ListJokes.get(randomIntJoke);
    }
}
