package com.cserny.test.model;

import com.cserny.test.entity.Product;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by user on 14.03.2016.
 */
public class ProductFieldSetMapper implements FieldSetMapper<Product>
{
    @Override
    public Product mapFieldSet(FieldSet fieldSet) throws BindException
    {
        Product product = new Product();
        product.setId(fieldSet.readInt("id"));
        product.setName(fieldSet.readString("name"));
        product.setDescription(fieldSet.readString("description"));
        product.setQuantity(fieldSet.readInt("quantity"));

        return product;
    }
}
