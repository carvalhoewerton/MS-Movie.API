package msmvapi.service;

import msmvapi.infra.FilmeClientOMDBFeing;
import msmvapi.model.Filme;
import msmvapi.model.FilmeDto;
import msmvapi.model.FilmeOMDB;
import msmvapi.repository.FilmeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeService {

    @Value("${imdb.apikey}")
    private String apiKey;

    @Autowired
    private FilmeClientOMDBFeing client;

    @Autowired
    private FilmeRepository filmeRepository;
    public FilmeOMDB getFilme(String tema){
        return client.getFilme(tema, apiKey);
    }


    public Filme save(FilmeDto filmeDto){
        var filme = new Filme();
        BeanUtils.copyProperties(filmeDto, filme);
        return filmeRepository.save(filme);
    }

    public List<Filme> filmes(){
        return filmeRepository.findAll();
    }

    public Optional<Filme> getFilme(UUID filmeId){
        return filmeRepository.findById(filmeId);
    }

}
