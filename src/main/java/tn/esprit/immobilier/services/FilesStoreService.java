package tn.esprit.immobilier.services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.immobilier.entities.Immobilier;

public interface FilesStoreService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public boolean deleteAll(String name) throws IOException;

    public Stream<Path> loadAll();

    public  byte[] getImageWithMediaType(String imageName) throws IOException;
}
