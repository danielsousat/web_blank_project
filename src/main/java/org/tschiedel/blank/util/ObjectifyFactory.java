/**
 * 
 */
package org.tschiedel.blank.util;

import org.springframework.stereotype.Component;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * Descricao: Factory para carregar as entidades e retornar a instancia do
 * Objectify.
 * 
 * <br><br>Data: 09/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
@Component
public class ObjectifyFactory {

	static {
        
		/**
		 * Inserir aqui as entidades do sistema pro Objectify usar.
		 */
		/*factory().register(Agencia.class);
		factory().register(Carro.class);*/
    }

	/**
	 * @return retorna a instancia do Objectify
	 */
    public static Objectify ofy() {
        
    	return ObjectifyService.ofy();
    }

    public static com.googlecode.objectify.ObjectifyFactory factory() {
        
    	return ObjectifyService.factory();
    }
}
