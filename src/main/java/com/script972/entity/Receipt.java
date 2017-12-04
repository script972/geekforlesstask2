package com.script972.entity;

public class Receipt {
    private String name;
    private String town;
    private String passportSer;
    private int number;
    private String take;
    private String home;
    private String landlord;
    private String summ;
    private String dateEpire;

    public Receipt(String name, String town, String passportSer, int number, String take, String home, String landlord, String summ, String dateEpire) {
        this.name = name;
        this.town = town;
        this.passportSer = passportSer;
        this.number = number;
        this.take = take;
        this.home = home;
        this.landlord = landlord;
        this.summ = summ;
        this.dateEpire = dateEpire;
    }

    public Receipt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportSer() {
        return passportSer;
    }

    public void setPassportSer(String passportSer) {
        this.passportSer = passportSer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        this.take = take;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    public String getDateEpire() {
        return dateEpire;
    }

    public void setDateEpire(String dateEpire) {
        this.dateEpire = dateEpire;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (number != receipt.number) return false;
        if (name != null ? !name.equals(receipt.name) : receipt.name != null) return false;
        if (passportSer != null ? !passportSer.equals(receipt.passportSer) : receipt.passportSer != null) return false;
        if (take != null ? !take.equals(receipt.take) : receipt.take != null) return false;
        if (home != null ? !home.equals(receipt.home) : receipt.home != null) return false;
        if (landlord != null ? !landlord.equals(receipt.landlord) : receipt.landlord != null) return false;
        if (summ != null ? !summ.equals(receipt.summ) : receipt.summ != null) return false;
        return dateEpire != null ? dateEpire.equals(receipt.dateEpire) : receipt.dateEpire == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passportSer != null ? passportSer.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (take != null ? take.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + (landlord != null ? landlord.hashCode() : 0);
        result = 31 * result + (summ != null ? summ.hashCode() : 0);
        result = 31 * result + (dateEpire != null ? dateEpire.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", passportSer='" + passportSer + '\'' +
                ", number=" + number +
                ", take='" + take + '\'' +
                ", home='" + home + '\'' +
                ", landlord='" + landlord + '\'' +
                ", summ='" + summ + '\'' +
                ", dateEpire='" + dateEpire + '\'' +
                '}';
    }
}
