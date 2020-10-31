package com.widua.spis.repository;

import com.widua.spis.collectives.Collective;
import com.widua.spis.model.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends CrudRepository<Citizen,String> {

    List<Citizen> getByFirstCollective(Collective firstCollective);
    List<Citizen> getBySecondCollective(Collective secondCollective);
    List<Citizen> getByAutonomy(boolean autonomy);
    Citizen getByDiscordNick(String discordNick);
    Citizen getByMinecraftNick(String minecraftNick);



}
