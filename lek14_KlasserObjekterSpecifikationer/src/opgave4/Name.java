package opgave4;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return getFirstName() + " " + getMiddleName() + " " + getLastName();
        // tilføj " ", for at lave lidt mellemrum mellem hver tekst streng.

    }
    public String getInit(){

        return firstName.substring(0,1) + middleName.substring(0,1) + lastName.substring(0,1);

    }
    public String getUsername(){
        return firstName.substring(0,2).toUpperCase() + middleName.length() + lastName.substring(0,2).toLowerCase();

    }
    public String getCryptoInit(int count){
        String init = getInit();
        String initCrypteret = "";

        //converterer streng til CharArray
        char[] ch = init.toCharArray();

        for (char c: ch){

            //vi vil gerne have en char (altså en karakter ud af det) efter vi har flyttet plads
            initCrypteret += (char) (c + count);
        }

        return initCrypteret;
    }

}
