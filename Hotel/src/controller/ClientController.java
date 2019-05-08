package controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.NoResultatException;
import models.Chambre;
import models.Chambreview;
import models.Typechambre;
import service.AdministrateurService;
import service.ClientService;

@Controller
//@RequestMapping("/")
public class ClientController {
		
	
	ClientService clientService=new ClientService() ;
	
	@RequestMapping(method = RequestMethod.GET, value="/")
    public String index(ModelMap model, HttpServletRequest request){
		return "/index";
    }
	
	@RequestMapping(value = {"/chambres"} , method = RequestMethod.GET)
	public String listechambre(ModelMap model,HttpServletRequest request) throws Exception{
		try{
			  List<Chambre> listechambre =clientService.getAllChambre();	     
			  model.addAttribute("listechambrefront",listechambre);
		      model.addAttribute("totalfront",listechambre.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/rooms";
		
		
	}
	///chambre/${item.nomchambre}
	@RequestMapping(value = {"/chambre/{nomchambre}"} , method = RequestMethod.GET)
	public String getchambrenomchambre(ModelMap model,@PathVariable("nomchambre") String nomchambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview liste= clientService.getAllDetailChambretotal(nomchambre);
		List<Chambreview> listecv=clientService.getAllDetailChambretotalrehetra(nomchambre);
		 model.addAttribute("listechambrecv",listecv);
		 model.addAttribute("listechambreview",liste);
		return "/description";
	}
	@RequestMapping(value = {"/typechambres"} , method = RequestMethod.GET)
	public String listetypechambre(ModelMap model) throws Exception{
		try{
			  List<Typechambre> listetypechambre =clientService.getAllTypeChambre();   
			  model.addAttribute("listechambrefront",listetypechambre);
		      model.addAttribute("totalfront",listetypechambre.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/typechambre";
		
		
	}
	
	
	@RequestMapping(value = {"/typechambre/{nomtype}"} , method = RequestMethod.GET)
	public String getchambretypenomchambre(ModelMap model,@PathVariable("nomtype") String nomtype) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		List<Chambreview> listecv=clientService.listechambreParType(nomtype);
		
		 model.addAttribute("listechambreparnom",listecv);
		return "/chambrepartype";
	}
	
	@RequestMapping(value = {"/typechambre/{nomtype}/{nomchambre}"} , method = RequestMethod.GET)
	public String getchambretypenomchambredETAIL(ModelMap model,@PathVariable("nomtype") String nomtype,@PathVariable("nomchambre") String nomchambre) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException{
		Chambreview listecv=clientService.getAllDetailChambretotal2(nomchambre, nomtype);
		List<Chambreview> liste=clientService.getAllDetailChambretotalrehetra(nomchambre);
		 model.addAttribute("listechambrecv",liste);
		 model.addAttribute("descriptionzay",listecv);
		return "/detailparnomparchambre";
	}
	/*@RequestMapping(value = {"/typechambre"} , method = RequestMethod.GET)
	public String listechambrePartypechambre(ModelMap model) throws Exception{
		try{
			  List<Typechambre> listetypechambre =clientService.getAllTypeChambre();   
			  model.addAttribute("listechambrefront",listetypechambre);
		      model.addAttribute("totalfront",listetypechambre.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "listechambre";
		
		
	}
	@RequestMapping(value = {"/rechercher/{nomchambre}"} , method = RequestMethod.GET)
	public String rechercheParNom(ModelMap model, HttpServletRequest request,@PathVariable("nomchambre") String nomchambre) throws Exception{
		try{
			  List<Chambre> listerecherche=clientService.rechercherchambreParNom(nomchambre);
			  model.addAttribute("listerecherche",listerecherche);
		      model.addAttribute("totalrecherche",listerecherche.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "recherche";
		
		
	}
	*/
	
}
