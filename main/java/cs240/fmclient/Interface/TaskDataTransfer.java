package cs240.fmclient.Interface;


import android.provider.Contacts;

import cs240.fmclient.AllPersonsResponse;
import cs240.fmclient.Models.Person;

public interface TaskDataTransfer {
    public Person[] getRelatives(AllPersonsResponse apr);
}
