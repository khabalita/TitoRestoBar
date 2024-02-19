package com.mycompany.titosrestobar.model;

import com.mycompany.titosrestobar.model.Pedido;
import com.mycompany.titosrestobar.model.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-18T19:39:20", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Double> precio;
    public static volatile SingularAttribute<Item, Integer> id_item;
    public static volatile SingularAttribute<Item, Pedido> pedido;
    public static volatile SingularAttribute<Item, Integer> cantidad;
    public static volatile SingularAttribute<Item, Producto> producto;

}