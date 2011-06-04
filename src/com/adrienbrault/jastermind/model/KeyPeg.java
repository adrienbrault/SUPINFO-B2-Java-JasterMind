package com.adrienbrault.jastermind.model;

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 11:42
 */
public enum KeyPeg {
    WRONG   (Color.black),
    COLOR   (Color.gray),
    BOTH    (Color.white);

    final Color color;

    KeyPeg(Color color) {
        this.color = color;
    }
}
