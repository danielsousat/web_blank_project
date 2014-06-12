/**
 * 
 */
package org.tschiedel.blank.dao;

import java.util.List;
import java.util.Map;

import org.tschiedel.blank.util.Ordem;


/**
 * Descricao: Dao base para os daos da aplicacao
 * 
 * <br><br>Data: 09/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
public interface CrudDao<T> {

	/**
	 * Recupera uma entidade pelo seu id.
	 * @param id
	 * @return a entidade ou nulo se nao encontrar
	 */
	T recuperar(Object id);
	
	/**
	 * Recupera todas entidades ordenadas atraves de um de seus campos.
	 * @param campoDeOrdenacao
	 * @param ordem tipo de ordenacao
	 * @return lista ordenada
	 */
	List<T> recuperarTodos(String campoDeOrdenacao, Ordem ordem);
	
	/**
	 * Recupera todas entidades ordenadas atraves de um ou mais campos.
	 * @param ordenacao mapa contendo os pares nome do campo e tipo de ordenacao.
	 * @return lista ordenada
	 */
	List<T> recuperarTodos(Map<String, Ordem> ordenacao);
	
	/**
	 * @return lista de todas as entidades.
	 */
	List<T> recuperarTodos();
	
	/**
	 * Recupera entidades filtradas cujo atributo seja igual a valor.
	 * @param atributo
	 * @param valor
	 * @return lista filtrada.
	 */
	List<T> recuperar(String atributo, Object valor);
	
	/**
	 * Recupera entidades filtradas cujo atributo seja igual a valor e as ordena
	 * conforme o campo e tipo de ordenacao informados.
	 * @param atributo
	 * @param valor
	 * @param campoDeOrdenacao
	 * @param ordem
	 * @return
	 */
	List<T> recuperar(String atributo, Object valor, 
			String campoDeOrdenacao, Ordem ordem);
	
	/**
	 * Recupera entidades filtradas a partir de um mapa de pares atributo e 
	 * respectivo valor e as ordena de acordo com o mapa de ordenacao.
	 * @param where
	 * @param ordenacao
	 * @return
	 */
	List<T> recuperar(Map<String, Object> where, Map<String, Ordem> ordenacao);
	
	/**
	 * Recupera entidades filtradas a partir de um par atributo e valor 
	 * e as ordena de acordo com o mapa de ordenacao.
	 * @param atributo
	 * @param valor
	 * @param ordenacao
	 * @return
	 */
	List<T> recuperar(String atributo, Object valor,
			Map<String, Ordem> ordenacao);
	
	/**
	 * Atualiza a entidade no banco
	 * @param entidade
	 * @return entidade apos a atualizacao
	 */
	T atualizar(T entidade);
	
	/**
	 * Insere nova entidade no banco.
	 * @param entidade
	 * @return entidade apos ser inserida.
	 */
	T inserir(T entidade);
	
	/**
	 * Remove determinada entidade do banco.
	 * @param entidade
	 */
	void apagar(T entidade);
}
