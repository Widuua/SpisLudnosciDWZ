package com.widua.spis.commands;

import com.widua.spis.commands.executable.AddCommand;
import com.widua.spis.commands.executable.DeleteCommand;
import com.widua.spis.commands.executable.EditCommand;
import com.widua.spis.commands.executable.SearchCommand;

public class CommandController {

    private Command command;




    public void setCommand(String commandName){
        commandName = commandName.toUpperCase();

        switch (commandName){
            case "ADD":{
                command = new AddCommand();
                break;
            }
            case "DELETE":{
                command = new DeleteCommand();
                break;
            }
            case "SEARCH":{
                command = new SearchCommand();
                break;
            }
            case "EDIT":{
                command = new EditCommand();
                break;
            }
        }

    }

    public void execute(){
        command.execute();
    }

}
