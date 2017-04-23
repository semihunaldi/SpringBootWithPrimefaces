package com.company.springbootwithprimefaces.util;

import com.company.springbootwithprimefaces.model.SimpleAbstractEntity;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 *
 */
public class UpperCaseUUIDGenerator extends UUIDGenerator
{
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException
    {
        if (object instanceof SimpleAbstractEntity) {
            SimpleAbstractEntity abstractEntity = (SimpleAbstractEntity)object;
            if (abstractEntity.getId() != null) {
                return abstractEntity.getId();
            }
        }
        Serializable generated = super.generate(session, object);
        return StringUtils.upperCase((String) generated);
    }
}

