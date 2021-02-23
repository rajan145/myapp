package rajan.wrkspot.demo.myapp.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rajan.wrkspot.demo.myapp.models.Corporation;
import rajan.wrkspot.demo.myapp.models.Hotel;
import rajan.wrkspot.demo.myapp.service.CorporationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/corp")
public class CorporationController {

    @Autowired
    private CorporationService corporationService;

    //Get All Corporations
    @RequestMapping("/")
    public List<Corporation> getCorporation(){
        return corporationService.findAll();
    }

    // Get Corporation Details by CorporationID
    @RequestMapping("/{corpId}")
    public Optional<Corporation> getCorporationDetailsByID(@PathVariable String corpId){
        return corporationService.getCorporationDetailsById(corpId);
    }

    // Get All the Hotels
    @RequestMapping("/{corpId}/hotels")
    public List<Hotel> getAllHotelsForCorporation(@PathVariable String corpId){
        return corporationService.findAllHotelsByCorp(corpId);
    }

    // get All the corporation by the lead firstName
    @RequestMapping("/lead/{firstName}")
    public List<Corporation> getCoporationByLead(@PathVariable String firstName){
        return corporationService.findCorporationByLead(firstName);
    }

    // Add new Corporation
    @RequestMapping(method = RequestMethod.POST, value ="/")
    public void addCorporation(@RequestBody List<Corporation> corporation){
        corporationService.save(corporation);
    }

    // update the hotels by the Corporation
    @RequestMapping(method = RequestMethod.PUT, value="/{corpId}/hotels")
    public void updateHotelForCorporation(@PathVariable String corpId, @RequestBody List<Hotel> hotels){
        corporationService.updateHotelByCorporationId(corpId, hotels);
    }

    // Remove the Corporation
    @RequestMapping(method =RequestMethod.DELETE, value= "/")
    public String removeCoporation(@PathVariable String corpId){
        corporationService.remove(corpId);
        return "Successfully Removed";
    }



}
