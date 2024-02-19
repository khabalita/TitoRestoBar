package com.mycompany.titosrestobar.model;

import com.mycompany.titosrestobar.model.Item;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-18T19:39:20", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fechaCierre;
    public static volatile SingularAttribute<Pedido, Boolean> estado;
    public static volatile SingularAttribute<Pedido, Date> fechaInicio;
    public static volatile SingularAttribute<Pedido, Double> descuento;
    public static volatile SingularAttribute<Pedido, Double> valorTotal;
    public static volatile SingularAttribute<Pedido, Double> subTotal;
    public static volatile SingularAttribute<Pedido, Integer> id_pedido;
    public static volatile ListAttribute<Pedido, Item> items;

}