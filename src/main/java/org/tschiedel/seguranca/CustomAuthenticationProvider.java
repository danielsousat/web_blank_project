/**
 * 
 */
package org.tschiedel.seguranca;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Descricao:
 * 
 * <br><br>Data: 22/05/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@valec.gov.br
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
	 */
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		System.out.println("name = " + auth.getName());	
		
		return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), 
				auth.getCredentials(), AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> auth) {
		
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
