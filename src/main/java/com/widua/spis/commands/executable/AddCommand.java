package com.widua.spis.commands.executable;

import com.widua.spis.ApplicationCore.Run;
import com.widua.spis.collectives.Collective;
import com.widua.spis.commands.Command;
import com.widua.spis.model.Citizen;
import org.springframework.stereotype.Component;

@Component
public class AddCommand implements Command {




    @Override
    public void execute() {
        System.out.println("How many Citizens you're gonna add to the database?");
        try{
            int how = Integer.parseInt(scan.nextLine());
            makeAndAddCitizen(how);
        } catch (Exception e){
            System.out.println("You must enter number!");
        }




    }


    public void makeAndAddCitizen(int howMany){
        for (int i = 0; i < howMany; i++) {
            System.out.println("Enter discord nick: ");
            String discordNick = scan.nextLine();
            discordNick = discordNick.toLowerCase();

            System.out.println("Enter minecraft nick: ");
            String minecraftNick = scan.nextLine();
            minecraftNick = minecraftNick.toLowerCase();

            System.out.print("Enter first collective: ");
            Collective firstCollective = collectiveChooser();

            System.out.println("Enter second collective: ");
            Collective secondCollective = collectiveChooser();

            System.out.println("Are citizen in Autonomic Village [Y/N]");
            String choose = scan.nextLine();
            boolean autonomy= false;
            if (choose.equals("Y") || choose.equals("y")){
                autonomy = true;
            }

            Citizen citizen = new Citizen(discordNick,minecraftNick,firstCollective,secondCollective,autonomy);
            System.out.println(citizen.toString());
            Run.citizenRepo.save(citizen);






        }



    }

    public static Collective collectiveChooser(){

        System.out.println("[BUDOWNICZY], [PRZEM], [HUTGUR], [LOGISTYCZNY], [DREWPAP], [ROLNICZY], [BRAK]");
        String readedCollective = scan.nextLine();

        switch (readedCollective.toUpperCase()){
            case "BUDOWNICZY":{
                return Collective.BUDOWNICZY;
            }
            case "PRZEM":{
                return Collective.PRZEMYSŁOWY;
            }
            case "HUTGUR":{
                return Collective.HUTNICZO_GÓRNICZY;
            }
            case "LOGISTYCZNY":{
                return Collective.LOGISTYCZNY;
            }
            case "DREWPAP":{
                return Collective.DREWNO_PAPIERNICZY;
            }
            case "ROLNICZY":{
                return Collective.ROLNICZY;
            }
            default:{
                return Collective.BRAK;
            }
        }

    }









}
