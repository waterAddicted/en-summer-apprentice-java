package com.endava.demo.controllers;


import com.endava.demo.services.ITicketCategoryService;
import com.endava.demo.model.TicketCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TicketCategory")
public class TicketCategoryController {
    @Autowired
    private ITicketCategoryService TicketCategoryService;

    public TicketCategoryController(com.endava.demo.services.TicketCategorieservice TicketCategoryService){
        this.TicketCategoryService = TicketCategoryService;
    }

    @GetMapping("/{TicketCategoryID}")
    public TicketCategory fetchOneTicketCategory(@PathVariable("TicketCategoryID") long TicketCategoryID){
        return this.TicketCategoryService.fetchOneTicketCategory(TicketCategoryID);
    }

    @GetMapping("/TicketCategories")
    public List<TicketCategory> fetchAllTicketCategorys(){
        return this.TicketCategoryService.fetchAllTicketCategorys();
    }

    @PostMapping
    public TicketCategory registerTicketCategory(@RequestBody TicketCategory TicketCategory){
        return this.TicketCategoryService.createTicketCategory(TicketCategory);
    }

    @PutMapping("/{TicketCategoryID}")
    public TicketCategory updateTicketCategory(@RequestBody TicketCategory TicketCategory, @PathVariable("TicketCategoryID") long TicketCategoryID){
        return this.TicketCategoryService.updateTicketCategory(TicketCategory, TicketCategoryID);
    }

    @DeleteMapping("/{TicketCategoryID}")
    public void deleteTicketCategory(@PathVariable("TicketCategoryID") long TicketCategoryID){
        this.TicketCategoryService.deleteTicketCategory(TicketCategoryID);
    }
}
