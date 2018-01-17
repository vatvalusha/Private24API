package classes.entity;

/**
 * Created by Valera on 15.01.2018.
 */
public class User {

    String name;
    int age;
    String password;
    Oid _id;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Oid get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", _id=" + _id +
                '}';
    }

    public void set_id(Oid _id) {
        this._id = _id;
    }

    public class Oid {
        String $oid;

        public String get$oid() {
            return $oid;
        }

        public void set$oid(String $oid) {
            this.$oid = $oid;
        }

    }
}
