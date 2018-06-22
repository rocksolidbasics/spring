package org.study.spring.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * The SavedRequestAwareAuthenticationbSuccessHandler extends SimpleUrlAuthenticationSuccessHandler,
 * and its default behaviour is to redirect (Code 301) after a successful login. But, for a REST service this
 * behaviour is not of any use as the clients of REST services are not browsers with redirect capabilities.
 * So, instead the SimpleUrlAuthenticationSuccessHandler is inherited and the default behaviour is 
 * overrided to return a 200 OK
 *
 */
@Component("mySuccessHandler")
public class SavedRequestAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private RequestCache reqCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication auth) throws ServletException, IOException {
		System.out.println("Success handler hit");
		SavedRequest sReq = getReqCache().getRequest(request, response);
		
		if(sReq == null) {
			this.clearAuthenticationAttributes(request);
			return;
		}
		
		String targetUrlParam = this.getTargetUrlParameter();
		if(this.isAlwaysUseDefaultTargetUrl() ||
				(targetUrlParam != null &&
				StringUtils.hasText(request.getParameter(targetUrlParam)))) {
			getReqCache().removeRequest(request, response);
			this.clearAuthenticationAttributes(request);
			return;
		}
		
		this.clearAuthenticationAttributes(request);
	}

	public RequestCache getReqCache() {
		return reqCache;
	}

	public void setReqCache(RequestCache reqCache) {
		this.reqCache = reqCache;
	}
}
