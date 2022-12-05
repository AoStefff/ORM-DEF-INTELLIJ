package Implementacions;

import Interficies.DAO;
import JPA_Main.JPAUtil;
import hybernates.ORM_DEF.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Implementacions implements DAO {

    @Override
    public List<Client> TotsCli(EntityManager entity) {

        List<Client> clients = new ArrayList<>();

        Query query=entity.createQuery("SELECT c FROM Client c");
        clients = query.getResultList();

        return clients;
    }

    @Override
    public Client cercaClient(int id, EntityManager entity) {

        //cerca un client mitjançant el seu id(dni).

        Client c;

        c = entity.find(Client.class, id);
        if (c == null) {
            System.out.println("Client no trobat!");
        }

        return c;

    }


    @Override
    public boolean createClient(Client cli, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.persist(cli);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

           System.out.println(e + " createClient");
            return false;
        }

        return true;

    }

    @Override
    public boolean updateClient(Client cli, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.merge(cli);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            System.out.println(e + " updateClient");
            return false;

        }

        return true;
    }

    @Override
    public boolean deleteClient(Client cli, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.remove(cli);
            entity.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e + " deleteClient");
            return false;

        }

        return true;
    }

    @Override
    public List<Bitllet> TotsBit(EntityManager entity) {

        List<Bitllet>bitllets=new ArrayList<>();

        Query query=entity.createQuery("SELECT b FROM Bitllet b");
        bitllets = query.getResultList();

        return bitllets;

    }

    @Override
    public Bitllet cercaBitllet(int id, EntityManager entity) {

        Bitllet b;

        b = entity.find(Bitllet.class, id);
        if (b == null) {
            System.out.println("Billet no trobat!");
        }

        return b;

    }

    @Override
    public boolean createBitllet(Bitllet bit, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.persist(bit);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            System.out.println(e + " createBitllet");
            return false;
        }

        return true;

    }

    @Override
    public boolean updateBitllet(Bitllet bit, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.merge(bit);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            System.out.println(e + " updateBitllet");
            return false;

        }

        return true;

    }

    @Override
    public boolean deleteBitllet(Bitllet bit, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.remove(bit);
            entity.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e + " deleteBitllet");
            return false;

        }

        return true;

    }

    @Override
    public List<Compra> TotsCom(EntityManager entity) {

        List<Compra>compres=new ArrayList<>();

        Query query=entity.createQuery("SELECT c FROM Compra c");
        compres = query.getResultList();

        return compres;

    }

    @Override
    public Compra cercaCompra(int id, EntityManager entity) {

        Compra c;

        c = entity.find(Compra.class, id);
        if (c == null) {
            System.out.println("Compra no trobada!");
        }

        return c;

    }

    //---------------------------------------------- Douglas  ----------------------------------------------------------------------------

    @Override
    public boolean createCompra(Compra com, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.persist(com);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            System.out.println(e + " createCompra");
            return false;
        }

        return true;

    }

    @Override
    public boolean updateCompra(Compra com, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.merge(com);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            System.out.println(e + " updateCompra");
            return false;

        }

        return true;

    }

    @Override
    public boolean deleteCompra(Compra com, EntityManager entity) {

        try {

            entity.getTransaction().begin();
            entity.remove(com);
            entity.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e + " deleteCompra");
            return false;

        }

        return true;

    }

    @Override
    public List<Equipatge> TotsEquip(EntityManager entity) {

        List<Equipatge>equipatges=new ArrayList<>();

        Query query=entity.createQuery("SELECT e FROM Equipatge e");
        equipatges = query.getResultList();

        return equipatges;

    }

    @Override
    public Equipatge cercaEquipatge(int id, EntityManager entity) {

        Equipatge q;

        q = entity.find(Equipatge.class, id);
        if (q == null) {
            System.out.println("Equipatge no trobat!");
        }

        return q;

    }

    //------------------------------------------------------------

    @Override
    public boolean createEquipatge(Equipatge equ, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(equ);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    @Override
    public boolean updateEquipatge(Equipatge equ, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(equ);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    @Override
    public boolean deleteEquipatge(Equipatge equ, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(equ);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public List<FacEquip> TotsFequip(EntityManager entity) {
        List<FacEquip> facEquips = new ArrayList<>();

        Query query=entity.createQuery("SELECT f FROM FacEquip f");
        facEquips = query.getResultList();

        return facEquips;
    }


    public FacEquip cercaFacEquipatge(int id, EntityManager entity) {
        //cerca una factura mitjançant el seu id.

        FacEquip f;

        f = entity.find(FacEquip.class, id);
        if (f == null) {
            System.out.println("Factura no trobada!");
        }

        return f;
    }


    public boolean createFacEquipatge(FacEquip feq, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(feq);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }


    public boolean updateFacEquipatge(FacEquip feq, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(feq);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }


    public boolean deleteFacEquipatge(FacEquip feq, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(feq);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    //-------------------------------- Arnau(Perpy) ------------------------------------------------------------


    public List<Localitat> TotsLoc(EntityManager entity) {
            List<Localitat> localitats = new ArrayList<>();

            Query query=entity.createQuery("SELECT l FROM Localitat l");
            localitats = query.getResultList();

        return localitats;
    }



    public Localitat cercaLocalitat(int id, EntityManager entity) {
        //cerca una localitat mitjançant el seu id.

        Localitat l;

        l = entity.find(Localitat.class, id);
        if (l == null) {
            System.out.println("Localitat no trobada!");
        }

        return l;
    }


    public boolean createLocalitat(Localitat loc, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(loc);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public boolean updateLocalitat(Localitat loc, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.merge(loc);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public boolean deleteLocalitat(Localitat loc, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.remove(loc);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public List<Transport> TotsTran(EntityManager entity) {
        List<Transport> transports = new ArrayList<>();

        Query query=entity.createQuery("SELECT t FROM Transport t");
        transports = query.getResultList();

        return transports;
    }

    public Transport cercaTransport(int id, EntityManager entity) {
        //cerca un transport mitjançant el seu id.

        Transport t;

        t = entity.find(Transport.class, id);
        if (t == null) {
            System.out.println("Transport no trobat!");
        }

        return t;
    }


    public boolean createTransport(Transport tra, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(tra);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public boolean updateTransport(Transport tra, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.merge(tra);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public boolean deleteTransport(Transport tra, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.remove(tra);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }

    public List<Viatge> TotsVia(EntityManager entity) {
        List<Viatge> viatges = new ArrayList<>();

        Query query=entity.createQuery("SELECT v FROM Viatge v");
        viatges = query.getResultList();

        return viatges;
    }

    public Viatge cercaViatge(int id, EntityManager entity) {
        //cerca un viatge mitjançant el seu id.

        Viatge v;

        v = entity.find(Viatge.class, id);
        if (v == null) {
            System.out.println("Viatge no trobat!");
        }

        return v;
    }

    @Override
    public boolean createViatge(Viatge via, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(via);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }
    @Override
    public boolean updateViatge(Viatge via, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.merge(via);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }
    @Override
    public boolean deleteViatge(Viatge via, EntityManager entity) {
        try {

            entity.getTransaction().begin();
            entity.persist(via);
            entity.getTransaction().commit();

        }
        catch(Exception e) {

            return false;

        }

        return true;
    }
}
