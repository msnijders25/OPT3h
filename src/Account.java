public class Account {
    Login login;
    Country country;

    Favorieten favorieten;

    Mandje mandje;

    Account(Login login, Country country){
    this.login = login;
    this.country = country;}

    protected Country getCountry(){
        return country;
    }
    protected Login getLogin(){
        return login;
    }
    protected void setMandje(Mandje mandje){
        this.mandje = mandje;
    }
    protected Mandje getMandje(){
        return mandje;
    }
}
