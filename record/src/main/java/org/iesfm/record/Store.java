package org.iesfm.record;

import java.util.*;


public class Store implements IStore {
    private String name;
    private String address;
    private HashMap<String, Record> records;
    private HashMap<String, Member> members;

    public Store(String name, String address, HashMap<String, Record> records, HashMap<String, Member> members) {
        this.name = name;
        this.address = address;
        this.records = records;
        this.members = members;
    }

    @Override
    public TreeSet<Record> recordsByGenre(String genre) {
        TreeSet<Record> genreRecord = new TreeSet<>();
        for (Record record : records.values()) {
            if (record.hasGenre(genre)) {
                genreRecord.add(record);
            }
        }
        return genreRecord;
    }

    @Override
    public HashSet<Member> membersByZipCode(int zipCode) {
        HashSet<Member> zipCodeMembers = new HashSet<>();
        for (Member member : members.values()) {
            if (member.getZipCode() == zipCode) {
                zipCodeMembers.add(member);
            }
        }
        return zipCodeMembers;
    }

    @Override
    public Boolean existRecord(String title) {
        return records.containsValue(title);
    }

    @Override
    public Member getMember(String nif) {
        return members.get(nif);
    }

    @Override
    public TreeSet<Record> getAuthorRecords(String author) {
        TreeSet<Record> authorRecords = new TreeSet<>();
        for (Record record : records.values()) {
            if (record.getAuthor().equalsIgnoreCase(author)) {
                authorRecords.add(record);
            }
        }
        return authorRecords;
    }

    @Override
    public List<Order> nifOrders(String nif) {
        List<Order> memberOrders = new LinkedList<>();
        for (Member member : members.values()) {
            if (member.getNif().equalsIgnoreCase(nif)) {
                memberOrders = member.getOrders();
            }
        }
        return memberOrders;
    }

    @Override
    public int nifSpending(String nif) {
        List<Order> memberOrders = nifOrders(nif);
        int spending = 0;
        for (Order order : memberOrders) {
            spending = spending + order.getPrice();
        }
        return spending;
    }

    @Override
    public HashMap<String, Record> removeRecord(String title) {
        HashMap<String, Record> removeRecord = records;
        for (Record record : removeRecord.values()) {
            if (record.getTitle().equalsIgnoreCase(title)) {
                removeRecord.remove(title, record);
            }
        }
        return removeRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, Record> getRecords() {
        return records;
    }

    public void setRecords(HashMap<String, Record> records) {
        this.records = records;
    }

    public HashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) && Objects.equals(address, store.address) && Objects.equals(records, store.records) && Objects.equals(members, store.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, records, members);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", records=" + records +
                ", members=" + members +
                '}';
    }
}
