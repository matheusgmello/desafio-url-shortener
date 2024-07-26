package dev.matheus.url_shortener.Links;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlLonga;
    private String urlEncurtada;
    private String urlQrCode;
    private LocalDateTime urlCriadaEm;
    private String urlOriginal;


    public Link() {
    }

    public Link(Long id, String urlLonga, String urlEncurtada, String urlQrCode, LocalDateTime urlCriadaEm) {
        this.id = id;
        this.urlLonga = urlLonga;
        this.urlEncurtada = urlEncurtada;
        this.urlQrCode = urlQrCode;
        this.urlCriadaEm = urlCriadaEm;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLonga() {
        return urlLonga;
    }

    public void setUrlLonga(String urlLonga) {
        this.urlLonga = urlLonga;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCriadaEm() {
        return urlCriadaEm;
    }

    public void setUrlCriadaEm(LocalDateTime urlCriadaEm) {
        this.urlCriadaEm = urlCriadaEm;
    }

}
