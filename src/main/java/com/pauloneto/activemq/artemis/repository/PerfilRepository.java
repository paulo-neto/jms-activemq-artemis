package com.pauloneto.activemq.artemis.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.pauloneto.activemq.artemis.models.Perfil;

/**
* @author paulo.antonio@fornecedores.sicoob.com.br 
* @version 0.1 - 29 de out de 2019
*/
@Repository
public interface PerfilRepository extends EntityRepository<Perfil, Long> {

}
