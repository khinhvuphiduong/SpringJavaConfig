package khanhnh.demo.site;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String getGreeting(String name) {
		// TODO Auto-generated method stub
		return "Hello " + name + "!";
	}
}
