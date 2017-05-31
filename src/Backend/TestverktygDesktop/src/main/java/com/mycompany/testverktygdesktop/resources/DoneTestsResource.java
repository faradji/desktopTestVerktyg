/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.DoneTest;
import com.mycompany.testverktygdesktop.repositories.DoneTestsRepository;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/donetests")
public class DoneTestsResource {

    DoneTestsRepository dr = new DoneTestsRepository();

    @GET
    public List<DoneTest> getDoneTests() {
        System.out.println("getDoneTests resource");
        return dr.getDoneTests();
    }
}
