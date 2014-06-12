/**
 * 
 */
package org.tschiedel.blank.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Descricao:
 * 
 * <br><br>Data: 10/06/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
public class Util {

	public static Map<String, Object> criarMapaComUmElemento(String chave, 
			Object valor) {
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put(chave, valor);
		
		return mapa;
	}
}
