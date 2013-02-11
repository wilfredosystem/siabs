package pe.com.technocamel.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pe.com.technocamel.dao.ClienteDAO;
import pe.com.technocamel.model.Cliente;

@Repository(value="clienteDAO")
public class HibernateClienteDAO implements ClienteDAO {
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Cliente> listar(int inicio, int limite) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		
		List<Cliente> clientes = hibernateTemplate.findByCriteria(criteria, inicio, limite);
		
		return clientes;
	}

	@Override
	public int getTotal() {
		
		return DataAccessUtils.intResult(hibernateTemplate.find("SELECT COUNT(*) FROM Cliente"));
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

}
