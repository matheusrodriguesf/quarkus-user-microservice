package org.arcelino.controller;

import lombok.AllArgsConstructor;
import org.arcelino.dto.UserForm;
import org.arcelino.dto.UserResponse;
import org.arcelino.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GET
    public List<UserResponse> all() {
        return userService.all();
    }

    @GET
    @Path("/{id}")
    public UserResponse get(@PathParam("id") Long id) {
        return userService.get(id);
    }

    @GET
    @Path("/search-by-name")
    public List<UserResponse> search(@QueryParam("name") String name) {
        return userService.findByName(name);
    }

    @POST
    public Response create(UserForm userForm) {
        userService.save(userForm);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UserForm userForm) {
        userService.update(id, userForm);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        userService.delete(id);
        return Response.ok().build();
    }
}
