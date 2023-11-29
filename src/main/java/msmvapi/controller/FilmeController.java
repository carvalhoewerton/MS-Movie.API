package msmvapi.controller;

import msmvapi.model.Filme;
import msmvapi.model.FilmeDto;
import msmvapi.model.FilmeOMDB;
import msmvapi.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/filme")
@RestController
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping("/omdb/{tema}")
    public ResponseEntity<FilmeOMDB> getFilme(@PathVariable String tema){
        try{
            FilmeOMDB filmeOMDB  = service.getFilme(tema);
            return ResponseEntity.status(HttpStatus.OK).body(filmeOMDB);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping
    public ResponseEntity<Filme> saveFilme(@RequestBody FilmeDto filmeDto){
        try{
            Filme filme = service.save(filmeDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(filme);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }}

    @GetMapping("/collection")
    public List<Filme> todos(){
        return service.filmes();
    }

    @GetMapping("/{filmeId}")
    public Optional<Filme> getFilme(@PathVariable UUID filmeId){
        return service.getFilme(filmeId);
    }


}
