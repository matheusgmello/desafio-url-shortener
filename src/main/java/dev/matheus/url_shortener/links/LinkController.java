package dev.matheus.url_shortener.Links;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;


@RestController
public class LinkController {

    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("encurta-ai")
    public ResponseEntity<LinkResponse> gerarUrlEncurtada(@RequestBody Map<String, String> request){
        String urlOriginal = request.get("urlOriginal");
        Link link = service.encurtarUrl(urlOriginal);

        String gerarUrlDeRedirecionamentoDoUsuario = "http://localhost:8080/r/" + link.getUrlEncurtada();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLonga(),
                gerarUrlDeRedirecionamentoDoUsuario,
                link.getUrlQrCode(),
                link.getUrlCriadaEm()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{urlEncurtada}")
    public void RedirecionarLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException{
        Link link = service.obterUrlOriginal(urlEncurtada);

        if(link != null) {
            response.sendRedirect(link.getUrlLonga());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
