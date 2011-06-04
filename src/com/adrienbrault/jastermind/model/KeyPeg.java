package com.adrienbrault.jastermind.model;

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 11:42
 */
public enum KeyPeg implements Peg {
    WRONG   (Color.black),
    COLOR   (Color.gray),
    CORRECT (Color.white);

    final protected Color color;

    KeyPeg(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
