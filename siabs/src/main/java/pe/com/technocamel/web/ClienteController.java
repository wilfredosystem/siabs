package pe.com.technocamel.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.technocamel.model.Cliente;
import pe.com.technocamel.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/cliente/listar.action", method=RequestMethod.GET)
	public @ResponseBody Map<String, ? extends Object> listar(@RequestParam int start, @RequestParam int limit) {
		List<Cliente> clientes = clienteService.listar(start, limit);
		int total = clienteService.getTotal();
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		respuesta.put("data", clientes);
		respuesta.put("total", total);
		respuesta.put("success", true);
		
		return respuesta;
	}
}
