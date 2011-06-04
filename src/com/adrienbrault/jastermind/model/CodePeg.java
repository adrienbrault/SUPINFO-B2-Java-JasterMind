package com.adrienbrault.jastermind.model;

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 11:41
 */
public enum CodePeg implements Peg {
    CODE_1  (Color.red),
    CODE_2  (Color.yellow),
    CODE_3  (Color.green),
    CODE_4  (Color.blue),
    CODE_5  (Color.orange),
    CODE_6  (Color.gray),
    CODE_7  (Color.pink),
    CODE_8  (Color.cyan);

    final protected Color color;

    CodePeg(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}