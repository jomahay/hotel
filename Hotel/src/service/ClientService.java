package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GeneralDao;
import exception.NoResultatException;
import models.BaseModel;
import models.Chambre;
import models.Chambreview;
import models.Equipement;
import models.Typechambre;

public class ClientService {
	public List<Typechambre> getAllTypeChambre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Typechambre> liste=new ArrayList<Typechambre>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Typechambre());
		for(int i=0;i<listebase.size();i++){
			liste.add((Typechambre)listebase.get(i));
		}
		return liste;
		
	}
	public List<Chambre> getAllChambre() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambre> liste=new ArrayList<Chambre>();
		List<BaseModel> listebase=new GeneralDao().findAll(new Chambre());
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambre)listebase.get(i));
			
		}
		return liste;
		
	}
	public List<Chambre> getAllChambreBytype(int idtype) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambre> liste=new ArrayList<Chambre>();
		List<BaseModel> listebase=new GeneralDao().find(new Chambre(),"idtype="+idtype+"'",null,null);
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambre)listebase.get(i));
		}
		return liste;
	}
	
	public Chambre getDetailChambre(int idchambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambre c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambre(), " id='"+idchambre+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambre) liste.get(i);
		}
		return c; 
		
		
	}
	public List<Chambre> rechercherchambreParNom(String nom) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambre> liste=new ArrayList<Chambre>();
		Chambre c =new Chambre();
		c.setNomchambre("%"+nom+"%");
		List<BaseModel> listebase=new GeneralDao().findAll(c);
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambre)listebase.get(i));
		}
		
		return liste;
		
		
	}
	
	public List<Chambreview> listechambreParType(String nom) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambreview> liste=new ArrayList<Chambreview>();
		
		
		List<BaseModel> listebase=new GeneralDao().find(new Chambreview() ,"nomtype='"+nom+"'",null,null);
		for(int i=0;i<listebase.size();i++){
			liste.add((Chambreview)listebase.get(i));
		}
		
		return liste;
		
		
	}
	public Chambreview getAllDetailChambretotal(int idchambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambreview(), " id='"+idchambre+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambreview) liste.get(i);
		}
		return c; 
		
		
	}
	public Chambreview getAllDetailChambretotal(String chambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambreview(), "nomchambre='"+chambre+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambreview) liste.get(i);
		}
		return c; 
		
		
	}
	public List<Chambreview> getAllDetailChambretotalrehetra(String chambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambreview> listes=new ArrayList<Chambreview>();
		List<BaseModel> liste=new GeneralDao().find(new Chambreview(), "nomchambre='"+chambre+"'",null,null);
		for(int i=0;i<liste.size();i++){
			listes.add((Chambreview) liste.get(i));
		}
		return listes; 
		
		
	}
	public Chambreview getAllDetailChambretotal2(String chambre,String nomtype) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview c=null;
		List<BaseModel> liste=new GeneralDao().find(new Chambreview(), "nomchambre='"+chambre+"' and nomtype='"+nomtype+"'",null,null);
		for(int i=0;i<liste.size();i++){
			c=(Chambreview) liste.get(i);
		}
		return c; 
		
		
	}
}
