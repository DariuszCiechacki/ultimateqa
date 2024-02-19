package library.modules.automation.fillingoutforms;

import com.github.javafaker.Faker;

public class FormsFactory {
    public static FormsDto createFormData(){
        FormsDto formData = new FormsDto();
        Faker faker = new Faker();

        formData.setName(faker.name().firstName());
        formData.setMessage(faker.lorem().characters());

        return formData;
    }
}
