package com.pauloneto.activemq.artemis.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pauloneto.activemq.artemis.models.Usuario;
import com.pauloneto.activemq.artemis.service.UsuarioService;

@Path("/usuarios")
public class UsuarioResource {

	@Inject
	private UsuarioService usuarioService;
	
	@GET
	@Path("/")
	@Produces(value = { MediaType.APPLICATION_JSON})
	public Response listar() {
		List<Usuario> retorno = usuarioService.listar();
		return retorno != null && !retorno.isEmpty() ? Response.ok(retorno).build() : Response.noContent().build();
	}

	@POST
	@Path("/")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response create(Usuario usuario) throws URISyntaxException {
		usuarioService.save(usuario);
		return Response.created(new URI("usuarios")).build();
	}
}
