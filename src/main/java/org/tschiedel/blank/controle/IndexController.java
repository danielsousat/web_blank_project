/**
 * 
 */
package org.tschiedel.blank.controle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tschiedel.blank.util.Paginas;

/**
 * Descricao:
 * 
 * <br><br>Data: 28/04/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
@Controller
@Scope("singleton")
public class IndexController {

	@RequestMapping(value = Paginas.INDEX_CAMINHO, method = RequestMethod.GET)
	public String index() {
				
		return Paginas.INDEX_JSP; 
	}	
}
