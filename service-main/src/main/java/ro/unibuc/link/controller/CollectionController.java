package ro.unibuc.link.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.link.data.CollectionEntity;
import ro.unibuc.link.data.UrlEntity;
import ro.unibuc.link.dto.CollectionDeleteDTO;
import ro.unibuc.link.dto.CollectionShowDTO;
import ro.unibuc.link.services.CollectionService;

@Controller
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService CollectionService;

    @GetMapping("/check/{collectionName}")
    public @ResponseBody
    boolean checkIfCollectionIsAvailable(@PathVariable String collectionName) {
        return CollectionService.checkCollectionNameIsAvailable(collectionName);
    }

    @PostMapping("/set")
    public @ResponseBody
    CollectionShowDTO setMapping(@RequestBody CollectionEntity collectionEntity) {
        return CollectionService.setCollection(collectionEntity);
    }

    @DeleteMapping("")
    public @ResponseBody
    CollectionShowDTO deleteMapping(@RequestBody CollectionDeleteDTO collectionDeleteDTO) {
        return CollectionService.deleteCollection(collectionDeleteDTO.getCollectionName(), collectionDeleteDTO.getPrivateWord());
    }

    @PostMapping("/add")
    public @ResponseBody
    CollectionShowDTO addUrl(@RequestBody CollectionDeleteDTO collectionDeleteDTO, @RequestBody UrlEntity urlEntity ) {
        return CollectionService.addUrlToCollection(collectionDeleteDTO, urlEntity);
    }

    @PostMapping("/remove")
    public @ResponseBody
    CollectionShowDTO removeUrl(@RequestBody CollectionDeleteDTO collectionDeleteDTO, @RequestBody UrlEntity urlEntity ) {
        return CollectionService.removeUrlFromCollection(collectionDeleteDTO, urlEntity);
    }
}
