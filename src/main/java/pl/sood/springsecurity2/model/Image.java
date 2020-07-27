package pl.sood.springsecurity2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;

    public Image() {
    }

    public Image( String imageuUrl) {
        this.id = id;
        this.imageUrl = imageuUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageuUrl() {
        return imageUrl;
    }

    public void setImageuUrl(String imageuUrl) {
        this.imageUrl = imageuUrl;
    }
}
