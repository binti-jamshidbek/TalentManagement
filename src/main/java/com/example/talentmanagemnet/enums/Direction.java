package com.example.talentmanagemnet.enums;

public enum Direction {
    REACT("React Web developer"),
    VUE("Vue Web developer"),
    ANGULAR("Angular Web developer"),
    FLUTTER("Flutter Mobile developer"),
    ANDROID("Android Mobile developer"),
    IOS("IOS Mobile developer"),
    JAVA("Java Backend Developer"),
    PYTHON("Python Backend Developer");
    private String value;

    Direction(String value) {
        this.value = value;
    }
}
