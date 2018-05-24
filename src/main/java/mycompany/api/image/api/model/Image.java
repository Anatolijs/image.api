package mycompany.api.image.api.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name= "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="tags")
    @ElementCollection
    private List<String> tags;

    public Image() {
    }

    public Image(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public List<String> getTags() {return tags;}

    public void setTags(List<String> tags) {this.tags = tags;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Image{" + "id= " + id + ", name= " + name + "}";
    }
}
