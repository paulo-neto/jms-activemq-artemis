package com.pauloneto.activemq.artemis.resources;

import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pauloneto.activemq.artemis.models.Usuario;

public class ProductListClientTest
{

   public static void main(String[] args)
   {
      list("http://localhost:8080/artemis/products");

   }

   public static void list(String uri)
   {
      Client client = ClientBuilder.newClient();
      Builder request = client.target(uri)
            .request().accept(MediaType.APPLICATION_JSON);
      Response response = request.buildGet().invoke();

      System.out.println("List of products " + Arrays.toString(response.readEntity(Usuario[].class)));
   }
}
