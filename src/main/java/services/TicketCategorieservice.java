package services;

import model.TicketCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TicketCategoriesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TicketCategorieservice implements ITicketCategoryService{
    private TicketCategoriesRepository TicketCategoryRepo;

    public TicketCategorieservice(TicketCategoriesRepository TicketCategoryRepo){
        this.TicketCategoryRepo = TicketCategoryRepo;
    }

    @Override
    public TicketCategoriesRepository getTicketCategoryRepo(){
        return this.TicketCategoryRepo;
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory TicketCategory) {
        return this.TicketCategoryRepo.save(TicketCategory);
    }

    @Override
    public TicketCategory fetchOneTicketCategory(Long TicketCategoryID) {
        return this.TicketCategoryRepo.findById(TicketCategoryID).get();
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategorys() {
        return (List<TicketCategory>) this.TicketCategoryRepo.findAll();
    }

    @Override
    public void deleteTicketCategory(Long TicketCategoryID) {
        this.TicketCategoryRepo.deleteById(TicketCategoryID);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory TicketCategory, Long TicketCategoryID) {
        TicketCategory updateTicketCategory = this.TicketCategoryRepo.findById(TicketCategoryID).get();
        updateTicketCategory.setEvent(TicketCategory.getEvent());
        updateTicketCategory.setDescription(TicketCategory.getDescription());
        updateTicketCategory.setPrice(TicketCategory.getPrice());
        return this.TicketCategoryRepo.save(updateTicketCategory);
    }
}
