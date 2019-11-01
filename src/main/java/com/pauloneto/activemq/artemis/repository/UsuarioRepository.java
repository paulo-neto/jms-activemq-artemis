package com.pauloneto.activemq.artemis.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.pauloneto.activemq.artemis.models.Usuario;

/**
* @author paulo.antonio@fornecedores.sicoob.com.br 
* @version 0.1 - 29 de out de 2019
*/
@Repository
public interface UsuarioRepository extends EntityRepository<Usuario, Long> {

}
