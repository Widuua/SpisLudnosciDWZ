package com.widua.spis.commands.executable;

import com.widua.spis.ApplicationCore.Run;
import com.widua.spis.commands.Command;
import com.widua.spis.model.Citizen;

public class DeleteCommand implements Command {

    @Override
    public void execute() {
        delete();
    }

    private void delete(){
        System.out.println("Enter discord nick of person");
        String discordNick = scan.nextLine().toLowerCase();
        Citizen citizen = Run.citizenRepo.getByDiscordNick(discordNick);
        if (citizen == null){
            System.out.println("No such person");
            return;
        }
        Run.citizenRepo.delete(citizen);
        System.out.println(citizen.getDiscordNick()+" has been successfully deleted");
    }



}
