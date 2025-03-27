package org.example;

public final class Example {
    private final String COLOR;
    private final int AGE;

    public Example(String color, int age) {
        COLOR = color;
        AGE = age;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public int getAGE() {
        return AGE;
    }

    public void messageEx() {
        System.out.println(COLOR + ", " + AGE);
    }
}
