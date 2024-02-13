package fr.pajonti.geogenerator.helpers;

import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.mappers.CountryMapper;
import fr.pajonti.geogenerator.mappers.FranceMapper;

public class MapperHelper {
    /**
     * Static method allowing to get the correct mapper according to a passed country code
     * @param country Country to deduce mapper from
     * @return Adequate mapper
     * @throws UnsupportedOperationException If there's no mapper designed for this country
     */
    public static CountryMapper getCountryMapperByCountry(Country country) throws UnsupportedOperationException{
        switch(country){
            case FRANCE -> {
                return new FranceMapper();
            }
            default -> {
                throw new UnsupportedOperationException("No mapper exists for the country code " + country.getCountryCode());
            }
        }
    }
}
