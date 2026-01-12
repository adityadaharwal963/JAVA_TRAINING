package models;


public class Customer {
    private String name;
    private long phone;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(String.valueOf(password.hashCode()));
    }

    public void setPassword(String password) {
        this.password = String.valueOf(password.hashCode());
    }
}
