package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Inializes the Web Application
@ComponentScan({"com.test"})
@SpringBootApplication
public class WebsiteTestPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteTestPageApplication.class, args);
	}

	/**
	 * Allows Swagger-Ui to Operate without throwing an MVC error
	 * @param webEndpointsSupplier - Web Endpoints Supplier
	 * @param servletEndpointsSupplier - Servlet Endpoints Supplier
	 * @param controllerEndpointsSupplier - Controller End Points Supplier
	 * @param endpointMediaTypes - End Point Media Types
	 * @param corsProperties - Cors Properties
	 * @param webEndpointProperties - Web End Points Properties
	 * @param environment - Environment
	 * @return WebMvcEndpointHandlerMapping, EndpointLinksResolver
	 */
	@SuppressWarnings("unchecked")
	@Bean
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier, ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier, EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties, WebEndpointProperties webEndpointProperties, Environment environment) {
		@SuppressWarnings("rawtypes")
		List<ExposableEndpoint<?>> allEndpoints = new ArrayList();
	    Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
	    allEndpoints.addAll(webEndpoints);
	    allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
        allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
	    String basePath = webEndpointProperties.getBasePath();
	    EndpointMapping endpointMapping = new EndpointMapping(basePath);
        boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
        return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes, corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath), shouldRegisterLinksMapping, null);
	}

	/**
	 * Helper Method for WebMvcEndpointHandlerMapping
	 * @param webEndpointProperties
	 * @param environment
	 * @param basePath
	 * @return webEndpointProperties, StringUtils, ManagementPortType
	 */
	private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
	    return webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
	}

}
