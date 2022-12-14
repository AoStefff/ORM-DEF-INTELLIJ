package Interficies;

import hybernates.ORM_DEF.*;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface DAO {
    List<Client> TotsCli(EntityManager entity);
    Client cercaClient(int id, EntityManager entity);

    boolean createClient(Client cli, EntityManager entity);
    boolean updateClient(Client cli, EntityManager entity);
    boolean deleteClient(Client cli,EntityManager entity);

    List<Bitllet> TotsBit(EntityManager entity);
    Bitllet cercaBitllet(int id, EntityManager entity);

    boolean createBitllet(Bitllet bit, EntityManager entity);
    boolean updateBitllet(Bitllet bit, EntityManager entity);
    boolean deleteBitllet(Bitllet bit, EntityManager entity);



    List<Compra> TotsCom(EntityManager entity);
    Compra cercaCompra(int id, EntityManager entity);

    boolean createCompra(Compra com, EntityManager entity);
    boolean updateCompra(Compra com, EntityManager entity);
    boolean deleteCompra(Compra com, EntityManager entity);


    List<Equipatge> TotsEquip(EntityManager entity);
    Equipatge cercaEquipatge(int id, EntityManager entity);

    boolean createEquipatge(Equipatge equ, EntityManager entity);
    boolean updateEquipatge(Equipatge equ, EntityManager entity);
    boolean deleteEquipatge(Equipatge equ, EntityManager entity);

    List<FacEquip> TotsFequip(EntityManager entity);
    FacEquip cercaFacEquipatge(int id, EntityManager entity);

    boolean createFacEquipatge(FacEquip feq, EntityManager entity);
    boolean updateFacEquipatge(FacEquip feq, EntityManager entity);
    boolean deleteFacEquipatge(FacEquip feq, EntityManager entity );



    List<Localitat> TotsLoc(EntityManager entity );
    Localitat cercaLocalitat(int id, EntityManager entity );

    boolean createLocalitat(Localitat loc, EntityManager entity );
    boolean updateLocalitat(Localitat loc, EntityManager entity );
    boolean deleteLocalitat(Localitat loc, EntityManager entity);


    List<Transport> TotsTran(EntityManager entity );
    Transport cercaTransport(int id,  EntityManager entity);

    boolean createTransport(Transport tra, EntityManager entity );
    boolean updateTransport(Transport tra, EntityManager entity );
    boolean deleteTransport(Transport tra, EntityManager entity );


    List<Viatge> TotsVia( EntityManager entity);
    Viatge cercaViatge(int id, EntityManager entity );

    boolean createViatge(Viatge via, EntityManager entity );
    boolean updateViatge(Viatge via, EntityManager entity );
    boolean deleteViatge(Viatge via,  EntityManager entity);



}
