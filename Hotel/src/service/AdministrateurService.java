package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.GeneralDao;
import exception.NoResultatException;

import models.Administrateur;
import models.BaseModel;
import models.Chambre;
import models.Chambreview;
import models.Equipement;
import models.Equipementchambre;
import models.Typechambre;



public class AdministrateurService {
	public static Administrateur connexion(String login, String password) throws Exception
    {
        List<BaseModel> liste = new GeneralDao().find(new Administrateur(), " nom='"+login+"' and mdpadmin='"+password+"'", null, null);
        for(int i=0;i<liste.size();i++)
        {
            Administrateur c = (Administrateur) liste.get(i);
            if(c.getNom().equals(login) && c.getMdpadmin().equals(password)){
                return c;
            }else{
            	throw new Exception("login/motdepasse incorrecte");
            	
            }
        }
        return null;
    }
	public Chambreview getChambreByName(String nom) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambreview(), "typechambre='"+nom+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambreview) liste.get(i);
		}
		return c; 
		
		
	}
	public void insererChambre(Chambre u){
		try {
			new GeneralDao().save(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	public void deleteChambre(Chambre u){
		try {
			new GeneralDao().delete(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateChambre(Chambre u){
		try {
			new GeneralDao().update(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insererEquipement(Equipement u){
		try {
			new GeneralDao().save(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	public void updateEquipement(Equipement u){
		try {
			new GeneralDao().update(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteEquipement(Equipement u){
		try {
			new GeneralDao().delete(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Chambre> getAllChambre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambre> liste=new ArrayList<Chambre>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Chambre());
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambre)listebase.get(i));
			
		}
		return liste;
		
	}
	public List<Typechambre> getAllTypeChambre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Typechambre> liste=new ArrayList<Typechambre>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Typechambre());
		for(int i=0;i<listebase.size();i++){
			liste.add((Typechambre)listebase.get(i));
			
		}
		return liste;
		
	}
	public List<Equipement> getAllEquipement() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Equipement> liste=new ArrayList<Equipement>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Equipement());
		for(int i=0;i<listebase.size();i++){
			liste.add((Equipement)listebase.get(i));
			
		}
		return liste;
		
	}
	public Chambre getChambreById(int idchambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambre c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambre(), " id='"+idchambre+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambre) liste.get(i);
		}
		return c; 
		
		
	}
	
	public Equipement getEquipementById(int idequipement) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Equipement c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambre(), " id='"+idequipement+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Equipement) liste.get(i);
		}
		return c; 
		
		
	}
	public List<Chambreview> getAllChambreview() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambreview> liste=new ArrayList<Chambreview>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Chambreview());
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambreview)listebase.get(i));
			
		}
		
		return liste;
		
		
		
	}
	public static Administrateur connexion2(String login, String password) throws Exception
    {
        List<BaseModel> liste = new GeneralDao().find(new Administrateur()," nom='"+login+"' and mdpadmin='"+password+"'", null, null);
        for(int i=0;i<liste.size();i++)
        {
            Administrateur c = (Administrateur) liste.get(i);
            if(c.getNom().equals(login) && c.getMdpadmin().equals(password))
                return c;
        }
        return null;
    }
	 public void insererEquipementChambre(int idchambre ,int idequipement,int nombre) throws Exception{
		 
		 GeneralDao gd=new GeneralDao();
		 
		
			 Equipementchambre ec=new Equipementchambre ();
			 ec.setIdchambre(idchambre);
			 ec.setIdequipement(idequipement);
			 ec.setNombre(nombre);
			 
			 gd.save(ec);
		
		 
	 }
	
}