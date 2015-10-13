package task.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import task.bean.Tehtava;
import task.dao.TehtavaDao;

@Controller
@RequestMapping (value="/")
public class TehtavaController {

	@Inject
	private TehtavaDao dao;
	
	public TehtavaDao getDao() {
		return dao;
	}

	public void setDao(TehtavaDao dao) {
		this.dao = dao;
	}
/*
	@RequestMapping(value="lista", method=RequestMethod.GET)
	public String haeKaikkiTehtavat(Model model) {
		List<Tehtava> tehtavat = dao.haeKaikki();
		model.addAttribute("tehtavat", tehtavat);	
		return "/";
	}
*/	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView startup() {
		ModelAndView mav = new ModelAndView("index");
		List<Tehtava> tehtavat = dao.haeKaikki();
		mav.getModelMap().put("tehtavat", tehtavat);	
		return mav;
	}

}