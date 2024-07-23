package dev.matheus.url_shortener.links;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlLong;
    private String urlEncurtada;
    private String urlQrCode;

    private LocalDateTime urlCriadaEm;

    public Link(Long id, LocalDateTime urlCriadaEm, String urlLong, String urlQrCode, String urlEncurtada) {
        this.id = id;
        this.urlCriadaEm = urlCriadaEm;
        this.urlLong = urlLong;
        this.urlQrCode = urlQrCode;
        this.urlEncurtada = urlEncurtada;
    }

    public Link(Long id) {
        this.id = id;
    }

    public Link() {

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

    public LocalDateTime getUrlCriadaEm() {
        return urlCriadaEm;
    }

    public void setUrlCriadaEm(LocalDateTime urlCriadaEm) {
        this.urlCriadaEm = urlCriadaEm;
    }
}
