package com.adrienbrault.jastermind.server;

import com.adrienbrault.jastermind.model.CodePeg;
import com.adrienbrault.jastermind.model.Peg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 12:26
 */
public class CodeMakerService implements Runnable {

    protected Socket socket;
    protected ObjectOutputStream objectOutputStream;
    protected ObjectInputStream objectInputStream;

    protected CodePeg[] secretCode = new CodePeg[Peg.LINE_SIZE];

    public CodeMakerService(Socket socket) {
        this.socket = socket;

        this.generateSecretCode();
    }

    protected void generateSecretCode() {
        Random randomGenerator = new Random();
        
        for (int i=0; i< Peg.LINE_SIZE; i++) {
            int randomPegIndex = randomGenerator.nextInt(CodePeg.values().length);
            this.secretCode[i] = CodePeg.values()[randomPegIndex];
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.secretCode;
    }


    public void run() {
        System.out.println("Service start: " + this);

        try {
            this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Service end: " + this);
        }
    }

}
