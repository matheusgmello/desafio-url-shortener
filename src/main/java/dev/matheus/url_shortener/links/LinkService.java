package dev.matheus.url_shortener.Links;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }

    // Gerando uma url aleatória
    // TODO: REFATORAR PARA INCLUIR PARTE DA URL ORIGINAL NO NOSSO ALGORITMO DE GERAÇÃO DE URL
    public String gerarUrlAleatoria() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link encurtarUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlLonga(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDISPONÍVEL NO MOMENTO");

        return repository.save(link);
    }

    public Link obterUrlOriginal(String urlEncurtada) {
        try {
            return repository.findByUrlEncurtada(urlEncurtada);
        } catch (Exception erro) {
            throw new RuntimeException("Url não existe no registro", erro);
        }
    }
}
