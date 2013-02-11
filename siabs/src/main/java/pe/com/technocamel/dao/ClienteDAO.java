package pe.com.technocamel.dao;

import java.util.List;

import pe.com.technocamel.model.Cliente;


public interface ClienteDAO {

	public List<Cliente> listar (int inicio, int limite);

	public int getTotal();
}
