package rajan.wrkspot.demo.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rajan.wrkspot.demo.myapp.models.Corporation;
import rajan.wrkspot.demo.myapp.models.Hotel;
import rajan.wrkspot.demo.myapp.repository.CorporationRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class CorporationService {

    @Autowired
    private CorporationRepository corporationRepository;

    public List<Corporation> findAll() {
        return corporationRepository.findAll();
    }

    public Optional<Corporation> getCorporationDetailsById(String corpId) {
        return corporationRepository.findById(corpId);
    }



    public List<Hotel> findAllHotelsByCorp(String corpId){
        Optional<Corporation> corp = corporationRepository.findById(corpId);
        return corp.isPresent()? corp.get().getHotels() : null;

    }

    public void save(List<Corporation> corporation) {

        corporation.stream()
                .forEach(c -> {
                    if(c.getHotels() == null) c.setHotels(new ArrayList<>());
                    corporationRepository.save(c);
                });

    }

    public void updateHotelByCorporationId(String corpId, List<Hotel> hotels) {
        Optional<Corporation> corp = corporationRepository.findById(corpId);
        corp.get().setHotels(hotels);
        corporationRepository.save(corp.get());
    }

    public List<Corporation> findCorporationByLead(String firstName) {
        return corporationRepository.findCropByLead(firstName);
    }

    public void remove(String corpId) {
        corporationRepository.deleteById(corpId);
    }
}
