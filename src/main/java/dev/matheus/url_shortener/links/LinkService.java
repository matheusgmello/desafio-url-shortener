package dev.matheus.url_shortener.links;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String gerarUrlAleatoria(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link encurtarUrl(String urlOrginal){
        Link link = new Link();
        link.setUrlLong(urlOrginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDISPONIVEL NO MOMENTO");

        return linkRepository.save(link);
    }

    public Link obterUrlOriginal(String urlEncurtada) {
        try {
            return linkRepository.findByUrlOriginal(urlEncurtada);
        } catch (Exception erro) {
            throw new RuntimeException("Url não existe no nosso registro");
        }
    }
}
