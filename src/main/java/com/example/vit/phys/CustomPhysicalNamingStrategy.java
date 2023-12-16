package com.example.vit.phys;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {


    @Override

    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {

        String prefix = "t_";

        if (name == null) {

            return null;

        }

        StringBuilder builder = new StringBuilder(prefix.length() + name.getText().length());

        builder.append(prefix);

        builder.append(name.getText());

        //return new Identifier(builder.toString(), name.isQuoted());

        String className = builder.toString();

        StringBuilder tableName = new StringBuilder();
        for (int i = 0; i < className.length(); i++) {

            char c = className.charAt(i);

            if (Character.isUpperCase(c)) {

                if (i != 0) {

                    tableName.append('_');

                }

                tableName.append(Character.toLowerCase(c));

            } else {

                tableName.append(c);

            }

        }
        String result = tableName.toString().replaceAll("__", "_");


        System.out.println(result);

        return Identifier.toIdentifier(result);


        //return Identifier.toIdentifier(builder.toString().toLowerCase());

    }


    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        if (name == null) {

            return null;

        }

        StringBuilder builder = new StringBuilder(name.getText().length() + 2);

        builder.append("f_");


        for (int i = 0; i < name.getText().length(); i++) {

            char c = name.getText().charAt(i);

            if (Character.isUpperCase(c)) {

                if (i != 0) {

                    builder.append('_');

                }

                builder.append(Character.toLowerCase(c));

            } else {

                builder.append(c);

            }

        }

        String result = builder.toString().replaceAll("__", "_");

        return Identifier.toIdentifier(result);
    }
}