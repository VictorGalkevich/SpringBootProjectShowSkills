package by.itstep.springApplication.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.annotations.SortNatural;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.*;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${app.image.bucket:/Users/vitali/Downloads/spring-starter/images}")
    private final String bucket;

    @SneakyThrows
    public void upload(String imagePath, InputStream content) {
        Path fullPath = Path.of(bucket, imagePath);

        try (content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public Optional<byte[]> get(String imagePath) {
        Path fullPath = Path.of(bucket, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }
}
