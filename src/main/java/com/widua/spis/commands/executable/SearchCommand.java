package com.widua.spis.commands.executable;

import com.widua.spis.ApplicationCore.Run;
import com.widua.spis.collectives.Collective;
import com.widua.spis.commands.Command;
import com.widua.spis.model.Citizen;

import java.util.List;

public class SearchCommand implements Command {

    @Override
    public void execute() {

        System.out.println("What need you to search");
        System.out.println("[1] Find citizen by discord nick");
        System.out.println("[2] Find citizen by minecraft nick");
        System.out.println("[3] Find citizens by collectives");
        System.out.println("[4] Find citizens by autonomy");
        System.out.println("[5] List all citizens");
        String option = scan.nextLine();

        switch (option){
            case "1":{
                findByDiscordNick();
                break;
            }
            case "2":{
                findByMinecraftNick();
                break;
            }
            case "3":{
                findAllByCollectives();
                break;
            }
            case "4":{
                findAllByAutonomy();
                break;
            }
            case "5":{
                listAll();
                break;
            }
        }

    }


    private void findByDiscordNick(){
        System.out.println("Enter discord nick: ");
        String discordNick = scan.nextLine().toLowerCase();
        Citizen citizen = Run.citizenRepo.getByDiscordNick(discordNick);
        System.out.println(citizen);

    }

    private void findByMinecraftNick(){
        System.out.println("Enter minecraft nick: ");
        String minecraftNick = scan.nextLine().toLowerCase();
        Citizen citizen = Run.citizenRepo.getByMinecraftNick(minecraftNick);
        System.out.println(citizen);

    }

    private void findAllByCollectives(){
        System.out.println("Podaj kolektyw");
        Collective col = AddCommand.collectiveChooser();
        List<Citizen> listf = Run.citizenRepo.getByFirstCollective(col);
        List<Citizen> lists = Run.citizenRepo.getBySecondCollective(col);

        for (Citizen citizen : listf) {
            System.out.println(citizen);
        }
        for (Citizen list : lists) {
            System.out.println(list);
        }

    }

    private void findAllByAutonomy(){
        System.out.println("All autonomic people: ");
        List<Citizen> autonomic = Run.citizenRepo.getByAutonomy(true);

        for (Citizen citizen : autonomic) {
            System.out.println(citizen);
        }


    }

    private void listAll(){
        for (Citizen citizen : Run.citizenRepo.findAll()) {
            System.out.println(citizen);
        }
        System.out.println("Together: "+ Run.citizenRepo.count() + " citizens.");
    }





}
