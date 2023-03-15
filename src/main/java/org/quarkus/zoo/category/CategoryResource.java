package org.quarkus.zoo.category;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/category")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Category", description = "Gerencia as categorias.")
public class CategoryResource {
    @Inject
    CategoryService categoryService;

    @GET
    @Path("/list")
    @Operation(summary = "Lista todas as categorias, suporta filtrar por nome.")
    public Response findAll(@QueryParam("name") String name) {
        if (name == null || name.isEmpty()) {
            return Response.ok(
                    categoryService.findAll()
                            .stream()
                            .map(CategoryMapper::entityToDto)
                            .collect(Collectors.toList())
            ).build();
        }
        return Response.ok(
                categoryService.findByName(name)
                        .stream()
                        .map(CategoryMapper::entityToDto)
                        .collect(Collectors.toList())
        ).build();
    }

    @GET
    @Path("/{uid}")
    @Operation(summary = "Obtém uma categoria específica.")
    public Response findOne(@PathParam("uid") String uid) {
        if (uid == null || uid.isEmpty()) {
            return Response.serverError().build();
        }
        return Response.ok(CategoryMapper.entityToDto(
                categoryService.findByUid(UUID.fromString(uid))
        )).build();
    }

    @POST
    @Operation(summary = "Cria uma nova categoria.")
    public Response create(@Valid CategoryDto categoryDto) {
        categoryService.create(CategoryMapper.dtoToEntity(categoryDto));
        return Response.noContent().build();
    }

    @PUT
    @Operation(summary = "Realiza a alteração de uma categoria.")
    public Response update(@Valid CategoryDto categoryDto) {
        categoryService.update(CategoryMapper.dtoToEntity(categoryDto));
        return Response.noContent().build();
    }

    @DELETE
    @Operation(summary = "Remove uma categoria com base no UID.")
    public Response remove(@QueryParam("uid") String uid) {
        categoryService.remove(UUID.fromString(uid));
        return Response.accepted().build();
    }
}
