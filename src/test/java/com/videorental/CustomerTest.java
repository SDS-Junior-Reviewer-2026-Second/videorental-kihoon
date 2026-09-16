package com.videorental;


import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void returnNewCustomer(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");

        assertNotNull(customer);
    }

    @Test
    public void statement(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        String statement = customer.statement();

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
        + "Amount owed is 0.0\n"
        + "You earned 0 frequent renter pointers", statement);

    }

    @Test
    public void statementForRegularMovieRentalForLessThan3Days(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.REGULAR);
        int daysRented = 2;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
        + "\t2.0(TITLE_NOT_IMPORTANT)\n"
        + "Amount owed is 2.0\n"
        + "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statementForNewReleaseMovie(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.NEW_RELEASE);
        int daysRented = 1;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t2.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statementForChildrenMovieRentalMoreThan3Days(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.CHILDRENS);
        int daysRented = 4;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t3.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statementForNewReleaseMovieRentalMoreThan1Day(){
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.NEW_RELEASE);
        int daysRented = 2;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\t6.0(TITLE_NOT_IMPORTANT)\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter pointers", statement);
    }

}
