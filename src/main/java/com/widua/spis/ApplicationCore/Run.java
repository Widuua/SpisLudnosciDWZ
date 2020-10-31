package com.widua.spis.ApplicationCore;

import com.widua.spis.commands.CommandController;
import com.widua.spis.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Run {

    public static CitizenRepository citizenRepo;

    @Autowired
    public void start(CitizenRepository citizenRepo){this.citizenRepo=citizenRepo;}


    private Scanner scan = new Scanner(System.in);


    @EventListener(ApplicationReadyEvent.class)
    public void runApplication(){

        while (true){
            String option = printMenu().toUpperCase();
            switch (option){
                case "EXIT":{
                    return;
                }
                case "ADD":{}
                case "DELETE":{}
                case "SEARCH":{}
                case "EDIT":{
                    CommandController cc = new CommandController();
                    cc.setCommand(option);
                    cc.execute();
                    break;
                }
                default:{
                    System.out.println("No such command");
                }
            }



        }




    }



    public String printMenu(){
        System.out.print("Choose command: ");
        System.out.println("[Add], [Delete], [Search], [Edit], [Exit]");
        String choise = scan.nextLine();
        return choise;
    }



}