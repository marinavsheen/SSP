package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import model.Javascript;
import service.DataService;


@RestController
@RequestMapping ("/")
public class RestSpringController {

	@Autowired
	DataService dataService;
	
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	// Logger instance
	private static final Logger logger = Logger.getLogger(RestSpringController.class);

	//get single item
	@RequestMapping(value = "/examples/{exampleName}", method = RequestMethod.GET)
	public @ResponseBody
	Javascript getItem(@PathVariable("exampleName") String request) {
		Javascript item = null;
		try {
			item = dataService.getEntityByName(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	//get all items
	@RequestMapping (value = "/itemlist", method = RequestMethod.GET)
	public @ResponseBody
	List<Javascript> listAllItems() {
		List <Javascript> items = dataService.getEntityList();
		return items;
	}
	
	//get list
	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String index (ModelMap mm) {
		mm.put("listItem", this.listAllItems());
		return "index";
	}
	
	@RequestMapping (value = "/examples/{exampleName}")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        logger.info("Returning Dojo.jsp"); 
        return new ModelAndView("{exampleName}.jsp"); 
    } 

	//TODO: add the other few methods
	/*@RequestMapping(value = "/<add method name here>", method = RequestMethod.POST)
	public String postSomething(@RequestParam(value = "request") String request,@RequestParam(value = "version", required = false, defaultValue = "1") int version) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start postSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : "+ request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End postSomething");
		}
		return response;
	}

	@RequestMapping(value = "/<add method name here>", method = RequestMethod.PUT)
	public String putSomething(@RequestBody String request,@RequestParam(value = "version", required = false, defaultValue = "1") int version) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : "+ request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
		return response;
	}

	@RequestMapping(value = "/<add method name here>", method = RequestMethod.DELETE)
	public void deleteSomething(@RequestBody String request,@RequestParam(value = "version", required = false, defaultValue = "1") int version) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
	}*/
}