package com.compliance.repo;

import java.io.Serializable;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl implements Serializable {

	public static final PhysicalNamingStrategyImpl INSTANCE = new PhysicalNamingStrategyImpl();

	@Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(name.getText(), name.isQuoted());
    }

}