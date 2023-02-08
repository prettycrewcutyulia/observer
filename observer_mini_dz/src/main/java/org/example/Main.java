package org.example;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Наблюдатель
interface Observer {
    void update(String gameTitle, String achievements, String briefInfo, String techInfo);
}

// Класс Игрок
class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void update(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(name + " received update: " + gameTitle + " with achievements: " + achievements);
    }
}

// Класс Журналист
class Journalist implements Observer {
    private String name;

    public Journalist(String name) {
        this.name = name;
    }

    @Override
    public void update(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(name + " received update: " + gameTitle + " - " + briefInfo);
    }
}

// Класс Разработчик
class Developer implements Observer {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void update(String gameTitle, String achievements, String briefInfo, String techInfo) {
        System.out.println(name + " received update: " + gameTitle + " with technical data: " + techInfo);
    }
}

// Класс Источник
class Console {
    private List<Observer> observers = new ArrayList<>();
    private String gameTitle;
    private String achievements;
    private String briefInfo;
    private String techInfo;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(gameTitle, achievements, briefInfo, techInfo);
        }
    }

    public void setNewGame(String gameTitle, String achievements, String briefInfo, String techInfo) {
        this.gameTitle = gameTitle;
        this.achievements = achievements;
        this.briefInfo = briefInfo;
        this.techInfo = techInfo;
        notifyObservers();
    }
}

public class Main {
    public static void main(String[] args) {
        Console console = new Console();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Journalist journalist1 = new Journalist("Journalist 1");
        Journalist journalist2 = new Journalist("Journalist 2");
        Developer developer1 = new Developer("Developer 1");
        Developer developer2 = new Developer("Developer 2");

        console.addObserver(player1);
        console.addObserver(player2);
        console.addObserver(journalist1);
        console.addObserver(journalist2);
        console.addObserver(developer1);
        console.addObserver(developer2);

        console.setNewGame("Game 1", "Achievements 1", "Brief info 1", "Technical info 1");
        console.setNewGame("Game 2", "Achievements 2", "Brief info 2", "Technical info 2");
    }
}
