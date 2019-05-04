package pl.em.swagger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirection to swagger api documentation
 */
@Slf4j
@RequiredArgsConstructor
@Controller
class DocumentationController {
	
	private static final String PATH = "redirect:swagger-ui.html";
	
	@RequestMapping(value = "/")
	String documentation() {
		log.info("Documentation of REST was started.");
		
		return PATH;
	}
	
}
