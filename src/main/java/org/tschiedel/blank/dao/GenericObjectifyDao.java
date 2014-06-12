/**
 * 
 */
package org.tschiedel.blank.dao;

/**
 * Descricao:
 * 
 * <br><br>Data: 11/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
public interface GenericObjectifyDao<T> extends CrudDao<T> {

	void setClazz(Class<T> clazz);
}
