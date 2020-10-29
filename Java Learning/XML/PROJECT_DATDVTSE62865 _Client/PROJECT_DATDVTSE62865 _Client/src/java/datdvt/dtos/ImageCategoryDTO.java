/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.dtos;

import java.util.List;

/**
 *
 * @author Admin
 */
public class ImageCategoryDTO {
    private CategoryDTO category;
    private List<ImageDTO> images;
    private int position;
    
    public ImageCategoryDTO() {
    }

    public ImageCategoryDTO(CategoryDTO category, List<ImageDTO> images, int position) {
        this.category = category;
        this.images = images;
        this.position = position;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
}
