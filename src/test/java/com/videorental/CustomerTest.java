package com.videorental;


import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    public static final String NAME = "NAME_NOT_IMPORTANT";
    public static final String TITLE = "TITLE_NOT_IMPORTANT";
    Customer customer = new Customer(NAME);

    @Test
    public void returnNewCustomer(){
        assertNotNull(customer);
    }

    @Test
    public void statement(){
        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
        + "Amount owed is 0.0\n"
        + "You earned 0 frequent renter pointers", customer.statement());

    }

    @Test
    public void statementForRegularMovieRentalForLessThan3Days(){

        customer.addRental(createRentalFor(Movie.REGULAR, 2));

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
        + "\t2.0(TITLE_NOT_IMPORTANT)\n"
        + "Amount owed is 2.0\n"
        + "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void statementForNewReleaseMovie(){

        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 1));

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t2.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void statementForChildrenMovieRentalMoreThan3Days(){

        customer.addRental(createRentalFor(Movie.CHILDRENS, 4));

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t3.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void statementForNewReleaseMovieRentalMoreThan1Day(){

        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 2));

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t6.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter pointers", customer.statement());
    }


    private static Rental createRentalFor(int priceCode, int daysRented) {
        Movie movie = new Movie(TITLE, priceCode);
        Rental rental = new Rental(movie, daysRented);
        return rental;
    }
}
