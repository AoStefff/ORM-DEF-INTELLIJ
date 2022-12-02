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
    public Client cercaClient(String dni, EntityManager entity) {

        //cerca un client mitjançant el seu id(dni).

        Client c;

        c = entity.find(Client.class, dni);
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
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteClient(Client cli, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from client where id_client="+cli.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public ArrayList<Bitllet> TotsBit(EntityManager entity) {
        ArrayList<Bitllet>bitllets=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from bitllets");
            rs.getRow();
            while (rs.next()){
                bitllets.add(new Bitllet(rs.getInt("id_bitllet"),rs.getDouble("preu"),rs.getInt("tipus_s"),rs.getInt("id_viatge")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bitllets;
    }

    @Override
    public Bitllet cercaBitllet(int id, EntityManager entity) {
        Bitllet b;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from bitllets where id_bitllet="+id);
            rs.getRow();
            rs.next();
            b=new Bitllet(rs.getInt("id_bitllet"),rs.getDouble("preu"),rs.getInt("tipus_s"),rs.getInt("id_viatge"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    @Override
    public boolean createBitllet(Bitllet bit, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into bitllets (preu,tipus_s,id_viatge) values("+bit.getPreu()+","+bit.getTipusSeient()+","+bit.getId_viatge()+")");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateBitllet(Bitllet bit, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update bitllets SET (preu,tipus_s,id_viatge) = ("+bit.getPreu()+","+bit.getTipusSeient()+","+bit.getId_viatge()+") where id_bitllet="+bit.getId_bitllet());
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteBitllet(Bitllet bit, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from bitllets where id_bitllet="+bit.getId_bitllet());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public ArrayList<Compra> TotsCom(EntityManager entity) {
        ArrayList<Compra>compres=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from compres");
            rs.getRow();
            while (rs.next()){
                compres.add(new Compra(rs.getInt("id_compra"),rs.getInt("id_bitllet"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getDate("data_compra").toLocalDate(),rs.getDouble("preu"),rs.getString("nom_viatger"),rs.getString("dni_viatger")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compres;
    }

    @Override
    public Compra cercaCompra(int id, EntityManager entity) {
        Compra c;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select *  from compres where id_compra="+id);
            rs.getRow();
            rs.next();
            c=new Compra(rs.getInt("id_compra"),rs.getInt("id_bitllet"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getDate("data_compra").toLocalDate(),rs.getDouble("preu"),rs.getString("nom_viatger"),rs.getString("dni_viatger"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }

    //---------------------------------------------- Douglas  ----------------------------------------------------------------------------

    @Override
    public boolean createCompra(Compra com, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into compres (id_bitllet,id_viatge,id_client,data_compra,preu,nom_viatger,dni_viatger) values('"+com.getIdBitllet()+"','"+com.getIdViatge()+"','"+com.getIdClient()+"','"+com.getDataCompra()+"','"+com.getPreu()+"','"+com.getNomPassatger()+"','"+com.getDniPassatger()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateCompra(Compra com, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update compres SET (id_compra,id_bitllet,id_viatge,id_client,data_compra,preu,nom_viatger,dni_viatger) = ("+com.getIdCompra()+","+com.getIdBitllet()+","+com.getIdViatge()+","+com.getIdClient()+",'"+com.getDataCompra()+"',"+com.getPreu()+",'"+com.getNomPassatger()+"','"+com.getDniPassatger()+"') where id_bitllet="+com.getIdBitllet()+" AND id_viatge="+com.getIdViatge());
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteCompra(Compra com, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from compres where id_bitllet="+com.getIdBitllet()+" AND id_viatge= "+com.getIdViatge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public ArrayList<Equipatge> TotsEquip(EntityManager entity) {
        ArrayList<Equipatge>equipatges=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from equipatge");
            rs.getRow();
            while (rs.next()){
                equipatges.add(new Equipatge(rs.getInt("id_equipatge"),rs.getString("nom"),rs.getDouble("pes"),rs.getDouble("preu")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipatges;
    }

    @Override
    public Equipatge cercaEquipatge(int id, EntityManager entity) {
        Equipatge q;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from equipatge where id_equipatge="+id);
            rs.getRow();
            rs.next();
            q=new Equipatge(rs.getInt("id_equipatge"),rs.getString("nom"),rs.getDouble("pes"),rs.getDouble("preu"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return q;
    }

    @Override
    public boolean createEquipatge(Equipatge equ, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into equipatge values("+equ.getId()+",'"+equ.getNom()+"',"+equ.getPes()+","+equ.getPreu()+")");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateEquipatge(Equipatge equ, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update equipatge SET("+equ.getId()+",'"+equ.getNom()+"',"+equ.getPes()+","+equ.getPreu()+") where id_equipatge="+equ.getId());
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteEquipatge(Equipatge equ, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from equipatge where id_equipatge="+equ.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ArrayList<FacEquip> TotsFequip(EntityManager entity) {
        ArrayList<FacEquip>facEquips=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from factura_equipatge");
            rs.getRow();
            while (rs.next()){
                facEquips.add(new FacEquip(rs.getInt("id_factura"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getInt("id_equipatge")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facEquips;
    }


    public FacEquip cercaFacEquipatge(int id, EntityManager entity) {
        FacEquip f;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from factura_equipatge where id_factura =" +id);
            rs.getRow();
            rs.next();
            f=new FacEquip(rs.getInt("id_factura"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getInt("id_equipatge"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return f;
    }


    public boolean createFacEquipatge(FacEquip feq, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into factura_equipatge(id_viatge,id_client,id_equipatge) values("+feq.getIdVia()+","+feq.getIdCli()+","+feq.getIdEqui()+")");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }


    public boolean updateFacEquipatge(FacEquip feq, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update factura_equipatge SET ("+feq.getId()+","+feq.getIdVia()+","+feq.getIdCli()+","+feq.getIdEqui()+") where id_factura="+feq.getId()+"");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }


    public boolean deleteFacEquipatge(FacEquip feq, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from factura_equipatge where id_factura="+feq.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    //-------------------------------- Arnau(Perpy) ------------------------------------------------------------


    public ArrayList<Localitat> TotsLoc(EntityManager entity) {
        ArrayList<Localitat>localitats=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from localitats");
            rs.getRow();
            while (rs.next()){
                localitats.add(new Localitat(rs.getInt("id_localitat"),rs.getString("nom"),rs.getString("pais"),rs.getString("abreviacio")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return localitats;
    }



    public Localitat cercaLocalitat(int id, EntityManager entity) {
        Localitat l;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from localitats where id_localitat="+id);
            rs.getRow();
            rs.next();
            l=new Localitat(rs.getInt("id_localitat"),rs.getString("nom"),rs.getString("pais"),rs.getString("abreviacio"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return l;
    }


    public boolean createLocalitat(Localitat loc, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into localitats (nom,pais,abreviacio) values('"+loc.getNom()+"','"+loc.getPais()+"','"+loc.getAbreviacio()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    public boolean updateLocalitat(Localitat loc, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update localitats SET (nom,pais,abreviacio) = ('"+loc.getNom()+"','"+loc.getPais()+"','"+loc.getAbreviacio()+"') where id_localitat="+loc.getId()+"");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    public boolean deleteLocalitat(Localitat loc, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from localitats where id_localitat="+loc.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ArrayList<Transport> TotsTran(EntityManager entity) {
        ArrayList<Transport>transports=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from transport");
            rs.getRow();
            while (rs.next()){
                transports.add(new Transport(rs.getInt("id_transport"),rs.getInt("s_normal"),rs.getInt("s_preferent"),rs.getString("nom"),rs.getInt("max_pes")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transports;
    }

    public Transport cercaTransport(int id, EntityManager entity) {
        Transport t;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from transport where id_transport="+id);
            rs.getRow();
            rs.next();
            t=new Transport(rs.getInt("id_transport"),rs.getInt("s_normal"),rs.getInt("s_preferent"),rs.getString("nom"),rs.getInt("max_pes"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return t;
    }


    public boolean createTransport(Transport tra, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into transport (s_normal,s_preferent,nom,max_pes) values("+tra.getsNormal()+","+tra.getsPreferent()+",'"+tra.getNom()+"',"+tra.getMaxPes()+")");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    public boolean updateTransport(Transport tra, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update transport SET (s_normal,s_preferent,nom) = ("+tra.getsNormal()+","+tra.getsPreferent()+",'"+tra.getNom()+"') where id_transport="+tra.getId());
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    public boolean deleteTransport(Transport tra, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from transport where id_transport="+tra.getId()+"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ArrayList<Viatge> TotsVia(EntityManager entity) {
        ArrayList<Viatge>viatges=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from viatge");
            rs.getRow();
            while (rs.next()){
                viatges.add(new Viatge(rs.getInt("id_viatge"),rs.getInt("id_origen"),rs.getInt("id_desti"),rs.getTimestamp("data").toLocalDateTime(),rs.getInt("id_transport"),rs.getBoolean("habilitat")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viatges;
    }

    public Viatge cercaViatge(int id, EntityManager entity) {
        Viatge v;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from viatge where id_viatge="+id);
            rs.getRow();
            rs.next();
            v=new Viatge(rs.getInt("id_viatge"),rs.getInt("id_origen"),rs.getInt("id_desti"),rs.getTimestamp("data").toLocalDateTime(),rs.getInt("id_transport"),rs.getBoolean("habilitat"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return v;    }

    @Override
    public boolean createViatge(Viatge via, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into viatge (id_origen,id_desti,data,id_transport,habilitat) values("+via.getIdOrigen()+","+via.getIdDesti()+",'"+via.getDataHora()+"',"+via.getIdTransport()+","+via.isHabilitat()+")");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }
    @Override
    public boolean updateViatge(Viatge via, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update viatge SET (id_origen,id_desti,data,id_transport,habilitat) = ("+via.getIdOrigen()+","+via.getIdDesti()+",'"+via.getDataHora()+"',"+via.getIdTransport()+","+via.isHabilitat()+") where id_viatge='"+via.getIdViatge()+"'");
        }
        catch(Exception a) {
            return false;
        }
        return true;
    }
    @Override
    public boolean deleteViatge(Viatge via, EntityManager entity) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Delete from viatge where id_viatge="+via.getIdViatge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
