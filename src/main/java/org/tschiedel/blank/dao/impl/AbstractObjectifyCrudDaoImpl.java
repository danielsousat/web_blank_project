/**
 * 
 */
package org.tschiedel.blank.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.tschiedel.blank.dao.CrudDao;
import org.tschiedel.blank.util.ObjectifyFactory;
import org.tschiedel.blank.util.Ordem;

import com.googlecode.objectify.cmd.LoadType;
import com.googlecode.objectify.cmd.Query;

/**
 * Descricao: Implementacao basica do objectifyDao
 * 
 * <br><br>Data: 09/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
public abstract class AbstractObjectifyCrudDaoImpl<T> implements CrudDao<T> {

	private Class<T> clazz;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractObjectifyCrudDaoImpl() {
		super();
		
		try {
			ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
			setClazz((Class) t.getActualTypeArguments()[0]);
		} catch (Exception e) {
			setClazz(null);
		}
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#atualizar(java.lang.Object)
	 */
	@Override
	public T atualizar(T entidade) {
		
		ObjectifyFactory.ofy().save().entity(entidade).now();
		
		return entidade;
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#inserir(java.lang.Object)
	 */
	@Override
	public T inserir(T entidade) {
		
		ObjectifyFactory.ofy().save().entity(entidade).now();
		
		return entidade;
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#apagar(java.lang.Object)
	 */
	@Override
	public void apagar(T entidade) {
		
		ObjectifyFactory.ofy().delete().entity(entidade).now();
		
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperar(java.lang.Object)
	 */
	@Override
	public T recuperar(Object id) {
		
		LoadType<T> load = ObjectifyFactory.ofy().load().type(getClazz());
		
		if (id instanceof Long) {
			
			return load.id((Long)id).now();
		}
		
		if (id instanceof String) {
			
			return load.id((String)id).now();
		}
		
		throw new ClassCastException("id nao eh Long nem String.");
	}
	
	public static String montarStringDeOrdenacao(String campoDeOrdenacao, 
			Ordem ordem) {
		
		if (ordem == Ordem.ASCENDENTE) {
			
			return campoDeOrdenacao;
		} else {
			
			return "-" + campoDeOrdenacao;
		}
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperarTodos(java.lang.String, org.tschiedel.blank.util.Ordem)
	 */
	@Override
	public List<T> recuperarTodos(String campoDeOrdenacao, Ordem ordem) {
		
		return ObjectifyFactory.ofy().load().type(getClazz()).order(
				montarStringDeOrdenacao(campoDeOrdenacao, ordem)).list();
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperarTodos(java.util.Map)
	 */
	@Override
	public List<T> recuperarTodos(Map<String, Ordem> ordenacao) {
		
		Query<T> query = ObjectifyFactory.ofy().load().type(getClazz());
		
		query = adicionarOrdenacoes(query, ordenacao);
		
		return query.list();
	}
	
	public Query<T> adicionarOrdenacoes(Query<T> query, 
			Map<String, Ordem> ordenacao) {
		
		for (Map.Entry<String, Ordem> entry : ordenacao.entrySet()) {
			
			query = query.order(montarStringDeOrdenacao(
					entry.getKey(), entry.getValue()));
		}
		
		return query;
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperarTodos()
	 */
	@Override
	public List<T> recuperarTodos() {
		
		return ObjectifyFactory.ofy().load().type(getClazz()).list();
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperar(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> recuperar(String atributo, Object valor) {
		
		return ObjectifyFactory.ofy().load().type(getClazz()).
				filter(atributo, valor).list();
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperar(java.lang.String, java.lang.Object, java.lang.String, org.tschiedel.blank.util.Ordem)
	 */
	@Override
	public List<T> recuperar(String atributo, Object valor,
			String campoDeOrdenacao, Ordem ordem) {
		
		return ObjectifyFactory.ofy().load().type(getClazz()).
				filter(atributo, valor).
				order(montarStringDeOrdenacao(campoDeOrdenacao, ordem)).
				list();
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperar(java.util.Map, java.util.Map)
	 */
	@Override
	public List<T> recuperar(Map<String, Object> where,
			Map<String, Ordem> ordenacao) {
		
		Query<T> query = ObjectifyFactory.ofy().load().type(getClazz());
		
		query = adicionarFiltros(query, where);
		query = adicionarOrdenacoes(query, ordenacao);
		
		return query.list();
	}
	
	public Query<T> adicionarFiltros(Query<T> query, Map<String, Object> where) {
		
		for (Map.Entry<String, Object> entry : where.entrySet()) {
			
			query = query.filter(entry.getKey(), entry.getValue());
		}
		
		return query;
	}

	/* (non-Javadoc)
	 * @see org.tschiedel.blank.dao.CrudDao#recuperar(java.lang.String, java.lang.Object, java.util.Map)
	 */
	@Override
	public List<T> recuperar(String atributo, Object valor,
			Map<String, Ordem> ordenacao) {
		
		Query<T> query = ObjectifyFactory.ofy().load().type(getClazz()).
				filter(atributo, valor);
		
		query = adicionarOrdenacoes(query, ordenacao);
		
		return query.list();
	}
}
