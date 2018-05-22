package mycompany.api.image.api.domain;

import java.util.List;

public class ImagesRequest {
    public List<ImageRequest> images;

    public static class ImageRequest {
        public Integer id;

        public String name;

        public List<String> tags;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
