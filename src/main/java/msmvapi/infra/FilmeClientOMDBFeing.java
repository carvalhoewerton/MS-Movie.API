package msmvapi.infra;

import msmvapi.model.FilmeOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="FilmeOMDB", url = "https://www.omdbapi.com/")
public interface FilmeClientOMDBFeing {
    @RequestMapping(method = RequestMethod.GET)
    FilmeOMDB getFilme(@RequestParam("t") String tema, @RequestParam("apiKey") String apiKey);
}
