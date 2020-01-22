package org.kizilay.yusuf.caveatemptor.controller;

import org.kizilay.yusuf.caveatemptor.resource.BidResource;
import org.kizilay.yusuf.caveatemptor.service.BidService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController extends BaseController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/item/{itemName}/bid")
    public void saveBid(@PathVariable String itemName, @RequestBody BidResource bidResource) {
        bidService.save(itemName, bidResource.getBidder(), bidResource.toDomain());
    }

    @PutMapping("item/{itemName}/bid")
    public void updateBid(@PathVariable String itemName, @RequestBody BidResource bidResource){

    }
}
