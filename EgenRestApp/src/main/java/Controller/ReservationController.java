/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ReservationDao;
import Exception.MyException;
import Model.Reservation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Sangram
 */
@Path("/reservations")
public class ReservationController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Reservation> findAll() {
        
        ArrayList<Reservation> allReservations = null;
        try {
            ReservationDao dao = new ReservationDao();
            allReservations = dao.findAll();
        } catch (MyException e) {
//            e.printStackTrace();
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
            
        }
        return allReservations;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Reservation findSingle(@PathParam("id") int id) {
        ReservationDao dao = new ReservationDao();
        Reservation singleReservation = null;
        try {
            singleReservation = dao.findSingle(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Status.NOT_FOUND);
        }

        return singleReservation;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation create(Reservation res) {
         ReservationDao dao = new ReservationDao();
        try {
           
            res = dao.create(res);
        } catch (MyException e) {
            e.printStackTrace();
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        return res;

    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation update(@PathParam("id") int id, Reservation res) {
       // Reservation res = new Reservation();
        ReservationDao dao = new ReservationDao();
        try {
            //res = dao.findSingle(id);
            res=dao.update(id, res);
        } catch (MyException e) {
            e.printStackTrace();
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return res;
    }

    @DELETE
    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        ReservationDao dao = new ReservationDao();
        Response resp = null;
        try {
            Reservation res = dao.findSingle(id);
            if(res!=null){
                dao.delete(id);
                return Response.ok().build();
            }
        } catch (MyException ex) {
            ex.printStackTrace();
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        } 
        return resp;
    }

}
