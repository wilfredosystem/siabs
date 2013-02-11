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
	private ClienteService clienteService;

	@RequestMapping(value = "/cliente/listar.action", method=RequestMethod.GET)
	public @ResponseBody Map<String, ? extends Object> listar(@RequestParam int start, @RequestParam int limit) {
		try {
			List<Cliente> clientes = clienteService.listar(start, limit);
			int total = clienteService.getTotal();
			
			Map<String, Object> respuesta = new HashMap<String, Object>(3);
			
			respuesta.put("data", clientes);
			respuesta.put("total", total);
			respuesta.put("success", true);
			
			return respuesta;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> respuestaError = new HashMap<String,Object>(2);
			respuestaError.put("message", "Error en recuperar Clientes desde la base de datos.");
			respuestaError.put("success", false);
			return respuestaError;
		}
	}
	
	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
}
