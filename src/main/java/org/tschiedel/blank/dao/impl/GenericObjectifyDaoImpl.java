/**
 * 
 */
package org.tschiedel.blank.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.tschiedel.blank.dao.GenericObjectifyDao;

/**
 * Descricao:
 * 
 * <br><br>Data: 11/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
@Repository
@Scope("prototype")
public class GenericObjectifyDaoImpl<T> extends AbstractObjectifyCrudDaoImpl<T> 
	implements GenericObjectifyDao<T> {

}
