package org.quarkus.zoo;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/zoo")
public class ZooResource {
/* REACTIVE
    @POST
    @Path("/animal/{nome}")
    public String generico(
            // Muito Utilizados:
            @RestPath String nome,
            @RestQuery String idade,
            @RestForm String cor,
            @RestHeader("X-Tipo-Pelo") String tipoPelo,
            // Pouco Utilizados:
            @RestMatrix String categoria,
            @RestCookie String temperamento
    ) {
        return String.format(
                "ZOO Animal\n"+
                "Nome: %s\n" +
                "Categoria: %s\n" +
                "Idade: %s\n" +
                "Cor: %s\n" +
                "Tipo de Pelo: %s\n" +
                "Temperamento: %s\n",
                nome,
                categoria,
                idade,
                cor,
                tipoPelo,
                temperamento
        );
    }
 */
}
