package mk.factory.code.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.factory.code.config.ConfClientAppConfiguration;

@RestController
@RequestMapping("/")
@RefreshScope
public class TestController {
	@Value("${service.instance.name}")
	private String instance;
	
	@Autowired
    ConfClientAppConfiguration confClientAppConfiguration;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	@GetMapping
	public String message() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("confClientAppConfiguration Property: " + confClientAppConfiguration.getProperty());
		sb.append("\n");
		sb.append("Property @VALUE: " + someOtherProperty);
		
		return sb.toString();
	}
}