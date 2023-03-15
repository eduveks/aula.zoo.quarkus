package org.quarkus.zoo.animal;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/animal")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Animal", description = "Gerencia os animais.")
public class AnimalResource {

    @Inject
    private AnimalService animalService;

    @GET
    @Operation(summary = "Lista todos os animais.")
    public List<AnimalDto> findByName(@QueryParam("name") String name) {
        List<Animal> animals = animalService.findByName(name);
        return animals.stream()
                .map(a -> AnimalMapper.entityToDto(a))
                .collect(Collectors.toList());
    }

    @POST
    @Operation(summary = "Cria um novo animal.")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Objeto criado em base de dados com o ID."
                    ),
                    @APIResponse(
                            responseCode = "500",
                            description = "Houve um problema grave na criação."
                    )
            }
    )
    public Animal create(@Valid AnimalDto animalDto) {
        return animalService.create(AnimalMapper.dtoToEntity(animalDto));
    }
}
