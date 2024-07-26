package dev.matheus.url_shortener.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

  Link findByUrlEncurtada(String urlEncurtada);
}
