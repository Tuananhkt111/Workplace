package datdvt.entities;

import datdvt.entities.Brand;
import datdvt.entities.Image;
import datdvt.entities.WebsiteCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T07:39:39")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Double> depth;
    public static volatile SingularAttribute<Product, String> material;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile CollectionAttribute<Product, Image> imageCollection;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Double> width;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Brand> brand;
    public static volatile SingularAttribute<Product, String> url;
    public static volatile SingularAttribute<Product, Double> height;
    public static volatile SingularAttribute<Product, WebsiteCategory> websiteCategory;

}