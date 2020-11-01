package com.widua.spis.model;

import com.widua.spis.collectives.Collective;

import javax.persistence.*;

@Entity
public class Citizen {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
*/
    @Id
    private String discordNick;
    private String minecraftNick;
    @Enumerated(EnumType.STRING)
    private Collective firstCollective;
    @Enumerated(EnumType.STRING)
    private Collective secondCollective;
    private boolean autonomy;

    public Citizen(){}

    public Citizen(String discordNick, String minecraftNick, Collective firstCollective, Collective secondCollective, boolean autonomy) {
        this.discordNick = discordNick;
        this.minecraftNick = minecraftNick;
        this.firstCollective = firstCollective;
        this.secondCollective = secondCollective;
        this.autonomy = autonomy;
    }
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/
    public String getDiscordNick() {
        return discordNick;
    }

    public void setDiscordNick(String discordNick) {
        this.discordNick = discordNick;
    }

    public String getMinecraftNick() {
        return minecraftNick;
    }

    public void setMinecraftNick(String minecraftNick) {
        this.minecraftNick = minecraftNick;
    }

    public Collective getFirstCollective() {
        return firstCollective;
    }

    public void setFirstCollective(Collective firstCollective) {
        this.firstCollective = firstCollective;
    }

    public Collective getSecondCollective() {
        return secondCollective;
    }

    public void setSecondCollective(Collective secondCollective) {
        this.secondCollective = secondCollective;
    }

    public boolean isAutonomy() {
        return autonomy;
    }

    public void setAutonomy(boolean autonomy) {
        this.autonomy = autonomy;
    }

    @Override
    public String toString() {
        return "Citizen: "+ discordNick+"\n"+
                "Minecraft nick: "+ minecraftNick+"\n"+
                "First collective: "+ firstCollective+"\n"+
                "Second collective: "+secondCollective+"\n"+
                "Autonomy: "+autonomy+"\n";
    }
}
