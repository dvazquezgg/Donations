package mx.edu.greengates.cs.donations.mapper;

import mx.edu.greengates.cs.donations.model.Charity;

public class CharityMapper {

    public static Charity mapToCharity(String name) {
        return new Charity(name);
    }

    public static String mapToString(Charity charity) {
        return charity.getName();
    }

    public static String mapToName(Charity charity) {
        return charity.getName();
    }
}
