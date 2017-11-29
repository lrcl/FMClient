package cs240.fmclient;

import cs240.fmclient.Models.Person;

public class AllPersonsResponse {

    /** contains an array  of Persons */
    private Person[] data;

    /** return the array  of Persons */

    public Person[] getData() {
        return data;
    }
    /** constructor
     * @param data */

    public AllPersonsResponse(Person[] data) {
        this.data = data;
    }

}

