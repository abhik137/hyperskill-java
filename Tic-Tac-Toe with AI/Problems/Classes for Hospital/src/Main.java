class Person {
    protected String name;
    protected int yearOfBirth;
    protected String address;
}

class Employee extends Person {
    protected Long salary;
}

class Doctor extends Employee {
    protected String specialization;
    protected String qualification;
    protected int experience;
}

class Patient extends Person {
    protected String diagnosis;
    protected String prescription;
}