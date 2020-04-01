public class Cat {

    String name;
    boolean sex;
    String breed;
    String eyecolor;
    String furcolor;
    boolean fluffytail;

    public Cat(String name, boolean sex, String breed, String eyecolor, String furcolor, boolean fluffytail) {

        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.eyecolor = eyecolor;
        this.furcolor = furcolor;
        this.fluffytail = fluffytail;

    }

    public Cat() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public void setFurcolor(String furcolor) {
        this.furcolor = furcolor;
    }

    public void setFluffytail(boolean fluffytail) {
        this.fluffytail = fluffytail;
    }



    @Override
    public String toString() {
        System.out.println("This cat " + name + ". About this: " + sex + breed + eyecolor + furcolor + fluffytail);
        return  null;
    };
}
