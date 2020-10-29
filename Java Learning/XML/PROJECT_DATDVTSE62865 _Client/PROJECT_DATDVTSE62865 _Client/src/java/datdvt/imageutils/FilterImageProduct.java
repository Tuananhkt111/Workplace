/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.imageutils;

import datdvt.clients.CategoryClient;
import datdvt.clients.ColorClient;
import datdvt.clients.ImageClient;
import datdvt.clients.ProductClient;
import datdvt.dtos.CategoriesDTO;
import datdvt.dtos.CategoryDTO;
import datdvt.dtos.ColorDTO;
import datdvt.dtos.ColorsDTO;
import datdvt.dtos.ImageCategoryDTO;
import datdvt.dtos.ImageDTO;
import datdvt.dtos.ImagesDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FilterImageProduct {
    public static final int NUMBER_RECURSIVE = 10000;
    public static List<ImageDTO> getImagesByColor(int r, int g, int b, int deviration, int accurate) {
        ColorClient cc = new ColorClient();
        ProductClient pc = new ProductClient();
        ImageClient ic = new ImageClient();
        List<ColorDTO> colorList = ((ColorsDTO) cc.getNearestColor_XML(ColorsDTO.class, String.valueOf(r), String.valueOf(g), String.valueOf(b), String.valueOf(deviration), String.valueOf(accurate))).getList();
        List<ImageDTO> imageList = new ArrayList<>();
        for (int i = 0; i < colorList.size(); i++) {
            ImagesDTO imagesDTO = (ImagesDTO) ic.getImagesByColorId_XML(ImagesDTO.class, String.valueOf(colorList.get(i).getId()));
            if (imagesDTO != null) {
                imageList.addAll(imagesDTO.getList());
            }
        }
        Collections.shuffle(imageList);
        return imageList;
    }

    public static List<CategoryDTO> getPriorityCategory(int auth) {
        CategoryClient cc = new CategoryClient();

        List<CategoryDTO> result = ((CategoriesDTO) cc.getCategoryByPriority_XML(CategoriesDTO.class, String.valueOf(auth))).getList();
        return result;
    }

    public static List<ImageCategoryDTO> getImageCategoriesWithColor(int priority, int r, int g, int b, int deviration, int accurate) {
        List<ImageCategoryDTO> result = new ArrayList<>();
        List<CategoryDTO> listCategories = getPriorityCategory(priority);
        List<ImageDTO> listImages = getImagesByColor(r, g, b, deviration, accurate);
        for (int i = 0; i < listCategories.size(); i++) {
            CategoryDTO categoryDTO = listCategories.get(i);
            List<ImageDTO> resultImages = new ArrayList<>();
            for (int j = 0; j < listImages.size(); j++) {
                ImageDTO imageDTO = listImages.get(j);
                if (imageDTO.getProduct().getWebsiteCategory().getCategory().getId() == categoryDTO.getId()) {
//                    System.out.println(imageDTO.getUrl());
                    if (priority == 1) {
                        if (imageDTO.getProduct().getWidth() != 0 && imageDTO.getProduct().getDepth() != 0 && imageDTO.getProduct().getHeight() != 0) {
                            resultImages.add(imageDTO);
                        }
                    } else {
                        resultImages.add(imageDTO);
                    }

                }
            }
            result.add(new ImageCategoryDTO(categoryDTO, resultImages, 0));

        }
        if (result != null) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).getImages() == null || result.get(i).getImages().size() == 0) {
                    result.remove(i);
                }
            }
        }
        return result;
    }

    public static int getPriceOfProduct(List<ImageCategoryDTO> list) {
        int result = 0;
        if (list == null) {
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImages().size() != 0) {
                result += list.get(i).getImages().get(list.get(i).getPosition()).getProduct().getPrice();
            }
        }
        return result;
    }

    public static float getAreaOfProduct(List<ImageCategoryDTO> list) {
        float result = 0;
        if (list == null) {
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImages().size() != 0) {
                float width = list.get(i).getImages().get(list.get(i).getPosition()).getProduct().getWidth();
                float depth = list.get(i).getImages().get(list.get(i).getPosition()).getProduct().getDepth();
                result += width * depth;
            }
        }
        return result;
    }

    public static boolean checkAppropriate(List<ImageCategoryDTO> list, float width, float depth) {
        boolean result = true;
        if (list == null) {
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImages().size() != 0) {
                float widthProduct = list.get(i).getImages().get(list.get(i).getPosition()).getProduct().getWidth();
                float depthProduct = list.get(i).getImages().get(list.get(i).getPosition()).getProduct().getDepth();
                if (widthProduct > width || depthProduct > depth) {
                    result = false;
                }
            }
        }

        return result;
    }


    public static List<ImageCategoryDTO> getListWithBoth(List<ImageCategoryDTO> list, int price, float width, float depth) {
        boolean hasPrice = true, hasArea = true;
        if (price == 0) {
            hasPrice = false;
        }
        if (width == 0 && depth == 0) {
            hasArea = false;
        } else {
            if (width < depth) {
                float temp = width;
                width = depth;
                depth = temp;
            }
        }
        boolean isFound = false;
        int count=0;
        while (!isFound && !isFullList(list) && count <=NUMBER_RECURSIVE) {
//            System.out.println("GET String list: " + getStringList(list));
            if (hasPrice && hasArea) {
                if (getPriceOfProduct(list) <= price && getAreaOfProduct(list) <= (width * depth) && checkAppropriate(list, width, depth)) {
                    return list;
                }
            } else if (hasPrice) {
                if (getPriceOfProduct(list) <= price) {
                    return list;
                }
            } else if (hasArea) {
                if (getAreaOfProduct(list) <= (width * depth) && checkAppropriate(list, width, depth)) {
                    return list;
                }
            }
            list = getPlusList(list);
            count++;
        }
        return null;

    }

    public static List<ImageCategoryDTO> getPlusList(List<ImageCategoryDTO> list) {
        int limit= 27;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImages() == null) {
                list.remove(i);
            } else if (list.get(i).getImages().size() == 0) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImages() != null) {
                if (list.get(i).getPosition() == list.get(i).getImages().size() - 1 || list.get(i).getPosition()==limit) {
                    list.get(i).setPosition(0);
                    continue;
                } else {
                    list.get(i).setPosition(list.get(i).getPosition() + 1);
                    break;
                }
            }
        }
        return list;
    }

    public static boolean isFullList(List<ImageCategoryDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPosition() != list.get(i).getImages().size() - 1) {
                return false;
            }
        }
        return true;
    }

    public static String getStringList(List<ImageCategoryDTO> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i).getPosition() + "-";
        }
        str += getPriceOfProduct(list);
        return str;
    }
//    public static List<ImageCategoryDTO> getListWithPrice(List<ImageCategoryDTO> list, float price) {
//        try {
//            if (list != null) {
//                for (int i = 0; i < list.size(); i++) {
//                    if (getPriceOfProduct(list) <= price) {
//                        return list;
//                    } else {
//                        System.out.println("LL" + list.get(i).getPosition());
////                System.out.println("get position");
//                        if (list.get(i).getPosition() <= list.get(i).getImages().size() - 1) {
//                            list.get(i).setPosition(list.get(i).getPosition() + 1);
//                            return getListWithPrice(list, price);
//                        }
//                    }
//                }
//            }
//            System.out.println("return null");
//        } catch (Exception e) {
//            return null;
//        }
//        return null;
//
//    }

}
