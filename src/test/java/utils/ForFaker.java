package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ForFaker {
    Faker faker = new Faker((new Locale("en-GB")));

    public String FirstName = faker.name().firstName(),
            LastName = faker.name().lastName(),
            UserEmail = faker.internet().emailAddress(),
            Gender = faker.options().option("Male", "Female", "Other"),
            UserNumber = faker.phoneNumber().subscriberNumber(10),
            BirthDay = String.format("%s",faker.number().numberBetween(1,28)),
            BirthMonth =faker.options().option("January","February","March","April","May","June","July","August","September","October","November","December"),
            BirthYear = String.format("%s",faker.number().numberBetween(1924,2010)),
            Subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology","Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History","Civics"),
            Hobbies = faker.options().option("Sports", "Reading", "Music"),
            Picture = faker.options().option("mountain-reflections-3840x2400.png","orig.png"),
            Address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = selectCity(state);

    public String selectCity(String state) {
        switch(state){

            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }

    }

}
