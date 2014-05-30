/**
 * 
 */
package org.tschiedel.blank;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Descricao:
 * 
 * <br><br>Data: 30/04/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
@WebAppConfiguration
public abstract class IntegrationTestBase {

	
}
