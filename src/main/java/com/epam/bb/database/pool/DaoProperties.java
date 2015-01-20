package com.epam.bb.database.pool;

import com.epam.bb.database.dao.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoProperties {
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            throw new DaoException(
                    "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new DaoException(
                    "Cannot load properties file '" + PROPERTIES_FILE + "'.", e);
        }
    }

private String specificKey;
    public DaoProperties(String specificKey) throws DaoException {
        this.specificKey = specificKey;
    }
    public String getProperty(String key) throws DaoException {
        String fullKey = specificKey + "." + key;
        return PROPERTIES.getProperty(fullKey);
    }
}

