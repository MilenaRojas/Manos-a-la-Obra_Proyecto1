package Domain;

public class Employee {
    //atributes

    private String name;
    private String lastName;
    private int identification;

    //constructors
    

    public Employee(String name_, String lastName_, int identification_) {
        this.name = name_;
        this.lastName = lastName_;
        this.identification = identification_;

    }
    public Employee() {
        this.name = "";
        this.lastName = "";
        this.identification = 0;

    }

    //get´s and set´s
    public String getName() {
        return name;
    }

    public void setName(String name_) {
        this.name = name_;
    }

    public String getSurname() {
        return lastName;
    }

    public void setSurname(String surname_) {
        this.lastName = surname_;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification_) {
        this.identification = identification_;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName_) {
        this.lastName = lastName_;
    }

    // calculateSalary
    public double calculateSalary(String id, int extraHour, int categoryType, boolean qualified) {

        int temp1 = id.charAt(0);
        int temp2 = id.charAt(1);
        double salary = 0;
        double extraTemp = 0;
        double extra = 0;
        double porcetageExtra = 0;

        //condcotor de carro
        if (temp1 == 48 && temp2 == 48) {
            salary = 20;
            if (qualified == true) {
                porcetageExtra = (3.95 / 100) * salary;
                salary += porcetageExtra;
            }
            //conductores de vagonetas
        } else if (temp1 == 48 && temp2 == 49) {
            salary = (26) + (52);
            if (qualified == true) {
                porcetageExtra = (3.95 / 100) * salary;
                salary += porcetageExtra;
            }
            //conductores de gruas
        } else if (temp1 == 48 && temp2 == 50) {
            salary = (28) + (56);
            if (qualified == true) {
                porcetageExtra = (3.95 / 100) * salary;
                salary += porcetageExtra;
            }
            //Conductores montacarga
        } else if (temp1 == 48 && temp2 == 51) {
            salary = (34) + (68);
            if (qualified == true) {
                porcetageExtra = (3.95 / 100) * salary;
                salary += porcetageExtra;

            } else if (temp1 == 49 && temp2 == 49) {
                extraTemp = 12 / 4;
                extra = extraTemp * extraHour;
                salary = 120 + extra;
                if (qualified == true) {
                    porcetageExtra = (3.95 / 100) * salary;
                    salary += porcetageExtra;
                }

            }
        }

        if (temp1 == 50 && temp2 == 50) {
            if (categoryType == 1) {
                salary = 250;
                if (qualified == true) {
                    porcetageExtra = (3.95 / 100) * salary;
                    salary += porcetageExtra;

                } else if (qualified == true) {
                    porcetageExtra = (3.95 / 100) * salary;
                    salary += porcetageExtra;
                }
                extraTemp = 250 / 5;
                salary = 250 + extraTemp;
            }

        }

        return salary;
    }
    public int size() {
        return getName().length()*2+ getLastName().length()*2+4;
    }
    @Override
    public String toString() {
        return "\nName:" + name + "\nLast Name:" + lastName + "\nIdentification:" + identification;
    }

}//end class

