package pe.com.technocamel.service;

import java.util.List;

import pe.com.technocamel.model.Cliente;

public interface ClienteService {
	public List<Cliente> listar(int inicio, int limite);

	public int getTotal();
}
