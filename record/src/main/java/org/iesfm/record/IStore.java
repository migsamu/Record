package org.iesfm.record;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public interface IStore {

    TreeSet<Record> recordsByGenre(String genre);

    HashSet<Member> membersByZipCode(int zipCode);

    Boolean existRecord(String title);

    Member getMember(String nif);

    TreeSet<Record> getAuthorRecords(String author);

    List<Order> nifOrders(String nif);

    int nifSpending(String nif);

    HashMap<String, Record> removeRecord(String title);

}
