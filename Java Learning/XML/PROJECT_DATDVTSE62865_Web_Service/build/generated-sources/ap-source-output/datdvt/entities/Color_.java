package datdvt.entities;

import datdvt.entities.Image;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T07:39:40")
@StaticMetamodel(Color.class)
public class Color_ { 

    public static volatile SingularAttribute<Color, Integer> r;
    public static volatile SingularAttribute<Color, Integer> b;
    public static volatile SingularAttribute<Color, Integer> g;
    public static volatile CollectionAttribute<Color, Image> imageCollection;
    public static volatile SingularAttribute<Color, String> name;
    public static volatile SingularAttribute<Color, Integer> id;

}