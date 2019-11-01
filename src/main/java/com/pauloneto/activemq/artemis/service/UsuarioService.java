/**
 * 
 */
package com.pauloneto.activemq.artemis.service;
/**
* @author paulo.antonio@fornecedores.sicoob.com.br 
* @version 0.1 - 29 de out de 2019
*/

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.pauloneto.activemq.artemis.jms.producer.EmailProducer;
import com.pauloneto.activemq.artemis.models.Usuario;
import com.pauloneto.activemq.artemis.repository.UsuarioRepository;

public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private EmailProducer emailProducer;
	
	@Transactional(value = TxType.REQUIRED)
	public Usuario save(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		emailProducer.sendEmail(String.format("Um novo usuário foi criado: %s", usuario.toString()));
		return usuario;
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
}
