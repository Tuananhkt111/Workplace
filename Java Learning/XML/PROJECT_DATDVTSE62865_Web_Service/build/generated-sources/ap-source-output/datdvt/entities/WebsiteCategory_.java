package datdvt.entities;

import datdvt.entities.Category;
import datdvt.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T07:39:39")
@StaticMetamodel(WebsiteCategory.class)
public class WebsiteCategory_ { 

    public static volatile SingularAttribute<WebsiteCategory, String> website;
    public static volatile CollectionAttribute<WebsiteCategory, Product> productCollection;
    public static volatile SingularAttribute<WebsiteCategory, String> name;
    public static volatile SingularAttribute<WebsiteCategory, Integer> id;
    public static volatile SingularAttribute<WebsiteCategory, Category> category;
    public static volatile SingularAttribute<WebsiteCategory, String> url;

}