package br.unifor.arquitetura.boot.hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/greeting")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private Map<Long, Greeting> products = new HashMap<>();

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method=RequestMethod.PUT)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		addProduct(greeting);
		return greeting;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Greeting greetingJson(@RequestBody Greeting product) {
		addProduct(product);
		return product;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Greeting>> getAll() {
		Collection<Greeting> values = products.values();
		List <Greeting> list = new ArrayList<>();
		
		list.addAll(values);
		return new ResponseEntity<List<Greeting>>(list, HttpStatus.OK);
	}

	private void addProduct(Greeting product) {
		long key = counter.incrementAndGet();
		product.setId(key);
		products.put(key, product);
	}
}