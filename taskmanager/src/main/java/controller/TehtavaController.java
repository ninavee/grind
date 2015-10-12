package controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller esimerkki, tän päälle voi tehdä tehtäväcontrollerin

/**	@Controller
@RequestMapping (value="/henkilot")
public class TehtavaController {

	@Inject
	private HenkiloDAO dao;
	
	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
		this.dao = dao;
	}
	
	//FORMIN TEKEMINEN
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Henkilo tyhjaHenkilo = new HenkiloImpl();
		tyhjaHenkilo.setEtunimi("oletusetunimi");
		
		model.addAttribute("henkilo", tyhjaHenkilo);
		return "henk/createForm";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="henkilo") HenkiloImpl henkilo) {
		dao.talleta(henkilo);
		return "redirect:/henkilot/" + henkilo.getId();
	}
	
	//HENKILÃ–N TIETOJEN NÃ„YTTÃ„MINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Henkilo henkilo = dao.etsi(id);
		model.addAttribute("henkilo", henkilo);
		return "henk/view";
	}
	
	//HENKILÃ–IDEN LISTAUS
	@RequestMapping(value="lista",method=RequestMethod.GET)
	public String getView(Map<String, Object> model) {
		model.put("henkilot", dao.haeKaikki());	
		return "henk/henkilolista";
	}
	
}**/