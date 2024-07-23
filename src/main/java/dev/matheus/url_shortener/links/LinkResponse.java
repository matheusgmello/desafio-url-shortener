package dev.matheus.url_shortener.links;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class LinkResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlLong;
    private String urlEncurtada;
    private String urlQrCode;

    private LocalDateTime urlCriadaEm;

    public LinkResponse() {
    }

    public LinkResponse(Long id, LocalDateTime urlCriadaEm, String urlLong, String urlQrCode, String urlEncurtada) {
        this.id = id;
        this.urlCriadaEm = urlCriadaEm;
        this.urlLong = urlLong;
        this.urlQrCode = urlQrCode;
        this.urlEncurtada = urlEncurtada;
    }

    public LocalDateTime getUrlCriadaEm() {
        return urlCriadaEm;
    }

    public void setUrlCriadaEm(LocalDateTime urlCriadaEm) {
        this.urlCriadaEm = urlCriadaEm;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }
}
