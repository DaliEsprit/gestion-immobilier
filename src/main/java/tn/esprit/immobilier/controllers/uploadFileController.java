package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.immobilier.entities.Attachement;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.services.FilesStoreService;
import tn.esprit.immobilier.services.IAttachmentService;
import tn.esprit.immobilier.services.ImmoblierService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@RestController

@RequestMapping("/up")
@CrossOrigin("*")
public class uploadFileController {
    @Autowired
    FilesStoreService FileStoreService;
    IAttachmentService attachementService;
    @PostMapping("/upload")
    public void addfile(@RequestBody MultipartFile file) {
        FileStoreService.init();
        FileStoreService.save(file);

    }


    @GetMapping(value ="/files/{id}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
    )
        public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "id") String fileName) throws IOException
        {
            return this.FileStoreService.getImageWithMediaType(fileName);
        }



}
