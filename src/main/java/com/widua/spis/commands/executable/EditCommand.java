package com.widua.spis.commands.executable;

import com.widua.spis.ApplicationCore.Run;
import com.widua.spis.collectives.Collective;
import com.widua.spis.commands.Command;
import com.widua.spis.model.Citizen;

public class EditCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Enter nick of who you want to edit: ");
        String discordNick = scan.nextLine().toLowerCase();
        Citizen citizen = Run.citizenRepo.getByDiscordNick(discordNick);
        if (citizen == null){
            System.out.println("Citizen doesn't exist!");
            return;
        }
        System.out.println("What do you need to edit?");
        System.out.println("[1] Discord nick");
        System.out.println("[2] Minecraft nick");
        System.out.println("[3] First collective");
        System.out.println("[4] Second collective");
        System.out.println("[5] Autonomy");
        String option = scan.nextLine();
        switch (option){
            case "1":{
                changeDiscordNick(citizen);
                break;
            }
            case "2":{
                changeMinecraftNick(citizen);
                break;
            }
            case "3":{
                changeFirstCollective(citizen);
                break;
            }
            case "4":{
                changeSecondCollective(citizen);
                break;
            }
            case "5":{
                changeAutonomy(citizen);
            }
        }
    }

    private void changeDiscordNick(Citizen citizen){
        Run.citizenRepo.delete(citizen);
        System.out.println("Type new discord nick: ");
        String discordNick = scan.nextLine().toLowerCase();
        citizen.setDiscordNick(discordNick);
        Run.citizenRepo.save(citizen);
        System.out.println("Discord nick has been changed successfully");
    }

    private void changeMinecraftNick(Citizen citizen){
        System.out.println("Type new minecraft nick: ");
        String minecraftNick = scan.nextLine();
        citizen.setMinecraftNick(minecraftNick);
        Run.citizenRepo.save(citizen);
    }

    private void changeFirstCollective(Citizen citizen){
        System.out.println("Enter new first collective: ");
        Collective collective = AddCommand.collectiveChooser();
        citizen.setFirstCollective(collective);
        Run.citizenRepo.save(citizen);

    }

    private void changeSecondCollective(Citizen citizen){
        System.out.println("Enter new second collective: ");
        Collective collective = AddCommand.collectiveChooser();
        citizen.setSecondCollective(collective);
        Run.citizenRepo.save(citizen);
    }

    private void changeAutonomy(Citizen citizen){
        System.out.println("Is he living in autonomic village? [Y/N]");
        String heIs = scan.nextLine();
        boolean isHe = false;
        if (heIs.equals("Y") || heIs.equals("y")){
            isHe = true;
        }
        citizen.setAutonomy(isHe);
        Run.citizenRepo.save(citizen);
    }

}
