package bg.softuni.offers.offers.web;

import bg.softuni.offers.offers.model.dto.AddOfferDto;
import bg.softuni.offers.offers.model.dto.OfferDto;
import bg.softuni.offers.offers.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( offerService.getOfferById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OfferDto> deleteById(@PathVariable("id") Long id){
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<OfferDto>> getAllOffers(){
        return ResponseEntity.ok(offerService.getAllOffers());
    }



    @PostMapping
    public ResponseEntity<OfferDto> createOffer(@RequestBody AddOfferDto addOfferDto){
        offerService.createOffer(addOfferDto);
        return ResponseEntity.ok().build();
    }

}
