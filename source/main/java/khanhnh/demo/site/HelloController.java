package khanhnh.demo.site;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	private GreetingService greetingService;
	
	@ResponseBody
	@RequestMapping("/")
	public String helloWord(){
		return "Hello, World!";
	}
	
	@ResponseBody
	@RequestMapping(value="/", params={"name"})
	public String helloName(@RequestParam("name") String name){
		return this.greetingService.getGreeting(name);
	}
	
	@Inject
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService=greetingService;
	}
}
