package edu.mum.cs545.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import edu.mum.cs545.model.Car;
import edu.mum.cs545.model.Greeting;
import edu.mum.cs545.model.HelloMessage;

@Controller
public class GreetingController {

	@RequestMapping("/ws")
	public String ws(Model m) {
		Car c = new Car();
		c.setName("Lexus");
		m.addAttribute("car", c);
		
		return "ws";
	}

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("........ greeting CarName: " + message.getCarName());
        return new Greeting("Hello3, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


}
