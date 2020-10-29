package datdvt.entities;

import datdvt.entities.Color;
import datdvt.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T07:39:39")
@StaticMetamodel(Image.class)
public class Image_ { 

    public static volatile SingularAttribute<Image, Product> product;
    public static volatile SingularAttribute<Image, Color> color;
    public static volatile SingularAttribute<Image, Integer> id;
    public static volatile SingularAttribute<Image, String> url;

}