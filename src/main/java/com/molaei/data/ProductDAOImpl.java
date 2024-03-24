package com.molaei.data;

import com.molaei.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    public void save(Product product) {
        Session session = getSession();
        session.save(product);
        session.close();
    }

    public List<Product> findAll() {
        Session session = getSession();
        Query from_product = session.createQuery("from Product");
        List<Product> products = from_product.list();
        session.close();
        return products;
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
        Product p = session.get(Product.class, id);
        session.delete(p);
        session.close();
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }
}
