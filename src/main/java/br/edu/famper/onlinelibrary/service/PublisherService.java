package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.PublisherDto;
import br.edu.famper.onlinelibrary.model.Publisher;
import br.edu.famper.onlinelibrary.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Provides an Editor´s List Formatted Like DTO...

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    @Autowired
    private PublisherRepository publisherRepository;

    //Method For Get All Publishers From Database...

    public List<PublisherDto> getAllPublishers() {
        return publisherRepository
                .findAll()
                .stream()
                .map(publisher -> PublisherDto
                        .builder()
                        .name(publisher.getName())
                        .publishedBook(publisher.getPublishedBook())
                        .build()
                )
                .toList();
    }

    //Method To Get One Publisher From Database...

    public PublisherDto getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        return new PublisherDto()
                .builder()
                .name(publisher.getName())
                .publishedBook(publisher.getPublishedBook())
                .build();
    }

    //Method For Add An New Publisher...

    public Publisher savePublisher(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.getName());
        publisher.setPublishedBook(publisherDto.getPublishedBook());
        return publisherRepository.save(publisher);
    }

    //Method For Update An Publisher From Database...

    public PublisherDto updatePublisher(Long id, PublisherDto publisherDto) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        publisher.setName(publisherDto.getName());
        publisher.setPublishedBook(publisherDto.getPublishedBook());
        Publisher publisherUpdated = publisherRepository.save(publisher);
        return new PublisherDto()
                .builder()
                .name(publisherUpdated.getName())
                .publishedBook(publisherUpdated.getPublishedBook())
                .build();
    }

    //Method For Delete One Publisher From Database...

    public boolean deletePublisher(Long id) {
        try {
            Publisher publisher = publisherRepository.findById(id).orElseThrow();
            publisherRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
