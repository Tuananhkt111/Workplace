package datdvt.entities;

import datdvt.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T07:39:39")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile CollectionAttribute<Brand, Product> productCollection;
    public static volatile SingularAttribute<Brand, String> name;
    public static volatile SingularAttribute<Brand, Integer> id;

}