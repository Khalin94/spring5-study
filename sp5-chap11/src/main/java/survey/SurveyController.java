package survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
/*	
	@GetMapping
	public String form() {
		return "survey/surveyForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}*/
	
	@GetMapping
	public ModelAndView form(Model model	) {
		List<Question> questions = createQuestion();
	/*	model.addAttribute("questions", questions);
		return "survey/surveyForm";
	*/
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	
	private List<Question> createQuestion(){
		Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버", "프론트", "풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 ?", Arrays.asList("Eclipse", "IntelliJ", "sublime"));
		Question q3 = new Question("하고 싶은 말");
		return Arrays.asList(q1,q2,q3);
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/sumitted";
	}

}