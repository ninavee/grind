package task.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import task.bean.Tehtava;
import task.dao.TestiDAO;

@Controller
@RequestMapping(value="/grind")
public class TehtavaController {
	
	@RequestMapping(value="hae")
	public String haeKaikki(Model model) {
		TestiDAO t = new TestiDAO();
		List<Tehtava> tehtavat = t.haeKaikki();
		model.addAttribute("tehtavat", tehtavat);	
		return "index";
	}
/*	
	@RequestMapping(value="lisaa", method=RequestMethod.POST)
	public String lisaaTaski(@RequestParam("task") String task,	@RequestParam("info") String info) {
		Tehtava t = new TehtavaImpl(task, info, 0, new Date(), new Date());
		TestiDAO dao = new TestiDAO();
		dao.talleta(t);
		return "redirect:/hae";
	}
*/
}