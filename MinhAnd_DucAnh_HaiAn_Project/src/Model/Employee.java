package Model;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String cccd;  
    private boolean isManager;

    public Employee(String id, String name, int age, String cccd, boolean isManager) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cccd = cccd;
        this.isManager = isManager;
    }

    // Getter & Setter
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCccd() { return cccd; }
    public boolean getIsManager() { return isManager; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCccd(String cccd) { this.cccd = cccd; }
    public void setIsManager(boolean isManager) { this.isManager = isManager; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + age + " AGE), Citizen Cdentification Card: " + cccd 
             + ", Role: " + (isManager ? "Manager" : "Employee");
    }
}
