package com.widua.spis.commands;


import java.util.Scanner;

public interface Command {

    Scanner scan = new Scanner(System.in);

    void execute();

}
