package br.com.radix.trabalhofinal;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import br.com.radix.trabalhofinal.controller.Servico;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class App {

	public static void main(String[] args) {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8181).build();
        ResourceConfig config = new ResourceConfig(Servico.class);
        Server server = JettyHttpContainerFactory.createServer(baseUri, config);
	}
}
