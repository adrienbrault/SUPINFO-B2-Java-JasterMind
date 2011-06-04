package com.adrienbrault.jastermind.server;

import com.adrienbrault.jastermind.model.CodePeg;

import java.net.Socket;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 12:26
 */
public class CodeMakerService implements Runnable {

    final static int CODE_SIZE = 4;

    protected Socket socket;
    protected CodePeg[] secretCode = new CodePeg[CODE_SIZE];

    public CodeMakerService(Socket socket) {
        this.socket = socket;

        this.generateSecretCode();
    }

    protected void generateSecretCode() {
        Random randomGenerator = new Random();
        
        for (int i=0; i< CODE_SIZE; i++) {
            int randomPegIndex = randomGenerator.nextInt(CodePeg.values().length);
            this.secretCode[i] = CodePeg.values()[randomPegIndex];
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.secretCode;
    }


    public void run() {
        System.out.println(this);
    }

}
