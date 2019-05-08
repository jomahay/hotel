package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import models.Administrateur;
import models.Chambre;
import models.Chambreview;
import models.Equipement;
import models.Equipementchambre;
import models.Typechambre;
import service.AdministrateurService;

@Controller
//@RequestMapping("/gestionnaire")
public class AdministrateurController {
		
	
	AdministrateurService administrateurService=new AdministrateurService();

	public AdministrateurService getAdministrateurService() {
		return administrateurService;
	}

	public void setAdministrateurService(AdministrateurService administrateurService) {
		this.administrateurService = administrateurService;
	}
	/**/@RequestMapping(value = {"/backoffice/","/backoffice"}, method = RequestMethod.GET)
	   public String index(HttpServletRequest request) {
			
			      return "/gestionnaire/login";
			   
	   }
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpServletRequest request){
        try {
            request.getSession().removeAttribute("nomadministrateur");
            request.getSession().setAttribute("success_m", " Administrateur deconnecté!");
        } catch (Exception ex) {
            request.getSession().setAttribute("error_m", ex.getMessage());
        }
        return "/gestionnaire/login";
    }
	 @RequestMapping(value = "/backoffice/loginlog", method = RequestMethod.POST)
	    public String login(@RequestParam("login") String login, @RequestParam("password") String password, ModelMap model, HttpServletRequest request)throws Exception{
	        
	        try {
	            Administrateur administrateur = administrateurService.connexion2(login, password);
	            if(administrateur==null ){
	                request.getSession().setAttribute("error_m", "Erreur de connexion");
	            	return "/gestionnaire/login";
	            }else{
	                request.getSession().removeAttribute("nomadministrateur");
	                request.getSession().setAttribute("nomadministrateur", administrateur.getNom());
	                request.getSession().setAttribute("success_m", administrateur.getNom()+" connecté!");
	                
	            }
	        }
	        catch (Exception ex) {
	            request.getSession().setAttribute("Erreur", ex.getMessage());
	        }
	        return "/gestionnaire/listechambres";
	    }
	
	@RequestMapping(method = RequestMethod.POST, value="/insererEquipement")
	   public String insererEquipement(
			  
			   @RequestParam("nomequipement") String nomequipement,ModelMap model, 
			   HttpServletRequest request) throws Exception{
		  
		Equipement c=new Equipement();
		c.setNomequipement(nomequipement);
		
		administrateurService.insererEquipement(c);
		   return "redirect:/backoffice/listeequipement";
	   }
	
	@RequestMapping(method = RequestMethod.POST, value="/insererEquipementChambre")
	   public String insererEquipementChambre(
			   @RequestParam("idequipement") String idequipement
			   ,@RequestParam("idchambre")String idchambre,@RequestParam("nombre")String nombre,ModelMap model, 
			   HttpServletRequest request) throws Exception{
		   //mP3Service.insererMusique(nomfichier, artiste, titre, album, annee, genre, image);
		int ide=Integer.valueOf(idequipement.trim());
		int idc=Integer.valueOf(idchambre.trim());
		int nb=Integer.valueOf(nombre.trim());
		Equipementchambre c=new Equipementchambre();
		c.setIdequipement(ide);
		c.setIdchambre(idc);
		c.setNombre(nb);
		administrateurService.insererEquipementChambre(idc, ide, nb);
		//administrateurService.insererEquipementChambre(ischambre, idequipement, nombre);
		   return "redirect:/backoffice/listechambres";
	   }
	@RequestMapping(method = RequestMethod.POST, value="/insererChambre")
	   public String insererChambre(
			   @RequestParam("nomchambre") String nomchambre
			   ,@RequestParam("idtype")String idtype,@RequestParam("nombrepersonne")String nombrepersonne,
			   
			   @RequestParam("imagechambre")String imagechambre,
			   @RequestParam("description")String description,
			   @RequestParam("prix")String prix,ModelMap model, 
			   HttpServletRequest request) throws Exception{
		   //mP3Service.insererMusique(nomfichier, artiste, titre, album, annee, genre, image);
		int idt=Integer.valueOf(idtype.trim());
		int np=Integer.valueOf(nombrepersonne.trim());
		int pr=Integer.valueOf(prix.trim());
		Chambre c=new Chambre();
		c.setDescription(description);
		c.setIdtype(idt);
		c.setImagechambre(imagechambre);
		c.setPrix(pr);
		c.setNombrepersonne(np);
		c.setNomchambre(nomchambre);
		administrateurService.insererChambre(c);
		   return "redirect:/backoffice/listechambres";
	   }
	/**/@RequestMapping(value = "/backoffice/listechambres", method = RequestMethod.GET)
	   public String listechambre(ModelMap model) throws Exception {
			try{
			  List<Chambre> listechambre =administrateurService.getAllChambre();		     
			  model.addAttribute("listechambre",listechambre);
		      model.addAttribute("total",listechambre.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/gestionnaire/listechambres";
	   }
	@RequestMapping(value = "/back/login", method = RequestMethod.GET)
	  public String login(HttpServletRequest request) {
		if (request.getSession().getAttribute("gestionnaire") != null) {
	      return "redirect:/back/";
	    }
	    return "/back/login";
	  }
	@RequestMapping(value = "/backoffice/listeequipement", method = RequestMethod.GET)
	   public String listeequipement(ModelMap model) throws Exception {
			try{
			  List<Equipement> listechambre =administrateurService.getAllEquipement();		     
			  model.addAttribute("listeequipement",listechambre);
		      model.addAttribute("total",listechambre.size());
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/gestionnaire/listeequipement";
	   }
	@RequestMapping(value = "/backoffice/InsertionChambrePage", method = RequestMethod.GET)
	   public String innsererChambrepage(ModelMap model) throws Exception {
		List<Typechambre> liste=administrateurService.getAllTypeChambre();
		 model.addAttribute("listetype",liste);
	      return "/gestionnaire/ajoutchambre";
	   }
	@RequestMapping(value = "/backoffice/InsertionEquipementPage", method = RequestMethod.GET)
	   public String innsererEquipementpage(ModelMap model) throws Exception {
			
	      return "/gestionnaire/ajoutequipement";
	   }
	@RequestMapping(value = "/backoffice/InsertionEquipementChambrePage", method = RequestMethod.GET)
	   public String innsererequipementchambrepage(ModelMap model) throws Exception {
			List<Chambre> listechambre=administrateurService.getAllChambre();
			List<Equipement> listeequipement=administrateurService.getAllEquipement();
			model.addAttribute("listechambre",listechambre);
			model.addAttribute("listeequipement",listeequipement);
	      return "/gestionnaire/ajoutequipementchambre";
	   }
	/**//*@RequestMapping(method = RequestMethod.POST, value="/connexion")
	   public String connexion(@RequestParam("utilisateur_login") String login,@RequestParam("utilisateur_password") String password,ModelMap model, HttpServletRequest request) throws Exception{
		Administrateur utilisateur = (Administrateur) administrateurService.connexion(login, password);
		   if(utilisateur!=null)
		   {
			   request.getSession().setAttribute("nomutilisateur", utilisateur.getNom());
			   request.getSession().setAttribute("idutilisateur", utilisateur.getId());
			   request.getSession().setAttribute("message", "Bienvenue "+utilisateur.getMdpadmin());
		   }
		   else {
			   request.getSession().setAttribute("message", "Erreur de connexion, veuillez recommencer!");
		   }
		   request.getSession().setAttribute("pageactive", "connexion");
		   return "redirect:/1";
	   }*/
	@RequestMapping(method = RequestMethod.GET, value="/deconnexion")
	   private String deconnexion(ModelMap model, HttpServletRequest request) throws Exception{
		   request.getSession().removeAttribute("nomutilisateur");
		   request.getSession().removeAttribute("idutilisateur");
		   request.getSession().setAttribute("pageactive", "connexion");
		   return "redirect:/1";
	   }
	@RequestMapping(value = "/backoffice/chambre-modifier/{id}", method = RequestMethod.GET)
	   public String modifierchambre(ModelMap model, @PathVariable("id") int id) throws Exception {
			try{
				
			  Chambre c=administrateurService.getChambreById(id);
			  
		      model.addAttribute("champ",c);
		     
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/gestionnaire/modifierChambre";
	   }
	   
	   @RequestMapping(value = "/backoffice/modificationChambre", method = RequestMethod.POST)
	   public String modificationChambre(ModelMap model,@RequestParam("nomchambre") String nomchambre,@RequestParam("prix") String prix,@RequestParam("description") String description,@RequestParam("nombrepersonne") String nombrepersonne,@RequestParam("idtype") Integer idtype,@RequestParam("imagechambre") String imagechambre, @RequestParam("id") Integer id) throws Exception {
			try{
				int np=Integer.valueOf(nombrepersonne.trim());
				int np2=Integer.valueOf(prix.trim());
				Chambre xd=new Chambre();
				xd.setId(id);
				xd.setDescription(description);
				xd.setNombrepersonne(np);
				xd.setNomchambre(nomchambre);
				xd.setPrix(np2);
				xd.setImagechambre(imagechambre);
				xd.setIdtype(idtype);
				
				
				administrateurService.updateChambre(xd);
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
			return "redirect:/backoffice/listechambres";
	   }
	   
	   @RequestMapping(value = "/backoffice/chambre-supprimer/{id}", method = RequestMethod.GET)
	   public String supprimerChambre(ModelMap model,@PathVariable("id") Integer id) throws Exception {
			try{
				Chambre xd=new Chambre();
				xd.setId(id);
				
				administrateurService.deleteChambre(xd);
			  
				
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
			return "redirect:/backoffice/listechambres";
	   }
	   
	   @RequestMapping(value = "/backoffice/equipement-modifier/{id}", method = RequestMethod.GET)
	   public String modifierequipement(ModelMap model, @PathVariable("id") int id) throws Exception {
			try{
				
			  Equipement c=administrateurService.getEquipementById(id);
			  
		      model.addAttribute("equipe",c);
		     
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
	      return "/gestionnaire/modifierEquipement";
	   }
	   
	   @RequestMapping(value = "/backoffice/modificationEquipement", method = RequestMethod.POST)
	   public String modificationEquipement(ModelMap model,@RequestParam("id") int id,@RequestParam("nomequipement") String nomequipement) throws Exception {
			try{
				Equipement eq=new Equipement();
				eq.setId(id);
				eq.setNomequipement(nomequipement);
				//System.out.println("musique:"+musique.getTitre()+","+musique.getFichier()+","+musique.getAnnee()+","+musique.getIdgenre()+","+musique.getIdalbum()+","+musique.getIdartiste());
				administrateurService.updateEquipement(eq);
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
			return "redirect:/backoffice/listeequipement";
	   }
	   
	   @RequestMapping(value = "/backoffice/equipement-supprimer/{id}", method = RequestMethod.GET)
	   public String supprimerEquipement(ModelMap model,@PathVariable("id") Integer id) throws Exception {
			try{
				Equipement wx=new Equipement();
				wx.setId(id);
				
				administrateurService.deleteEquipement(wx);
			  
				
			} catch (Exception e) {
				
				e.printStackTrace();
		   }
			return "redirect:/backoffice/listeequipement";
			//redirect:/backoffice/listeequipement
	   }
	   






}

